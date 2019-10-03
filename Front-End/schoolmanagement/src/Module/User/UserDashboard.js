import React from 'react';
import cookie from 'react-cookies';
import AddUser from './AddUser';
import Login from '../Login/Login';
import {Route, NavLink} from 'react-router-dom';
import Profile from './Profile';
import './UserDashboard.css';

class UserDashboard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userDetails: []
    };
}

onLogout(){
  if(cookie.load('schoolManagementCookie')!==null && cookie.load('schoolManagementCookie')!== undefined){
    fetch("http://localhost:8080/schoolmanagement/userLogout?key=SHARED_KEY",{
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      method: "POST",
      body: JSON.stringify({"userId":cookie.load('schoolManagementCookie').userId,"token":cookie.load('schoolManagementCookie').token})
    })
      .then(res => res.json())
      .then(
        (result) => {
          if(result.message === "Success"){
            cookie.remove('schoolManagementCookie',{ path: '/' });
            this.props.history.index=0;
            this.props.history.push('/');
          }
        }
      )
  }
}

render() {
  return (
        <div>
        <div className="header">
        <div className="sidenav">
          <div className="sidenavOptions"><NavLink to="/userdashboard/profile">Profile</NavLink></div>
          <div className="sidenavOptions"><NavLink to="/userdashboard/profile">Class</NavLink></div>
          <div className="sidenavOptions"><NavLink to="/userdashboard/profile">Department</NavLink></div>
          <div className="sidenavOptions"><NavLink to="/userdashboard/profile">Contact</NavLink></div>
          <div className="sidenavOptions" onClick={() => this.onLogout()}><NavLink to="/">Logout</NavLink></div>
      </div>
      </div>
          <div className="content">
          <Route exact path = {this.props.match.path} component = {Profile}/>
          <Route path = {'${this.props.match.path/adduser}'} component = {AddUser} />
          <Route path = {'${this.props.match.path/profile}'} component={Profile} />
          </div>
        </div>
  );
}
}
export default UserDashboard;
