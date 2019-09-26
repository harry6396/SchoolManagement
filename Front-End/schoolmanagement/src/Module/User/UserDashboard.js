import React from 'react';
import './UserDashboard.css';
import cookie from 'react-cookies';

class UserDashboard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: ''
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
    <div className="header">
      <div className="sidenav">
          <div className="sidenavOptions">Profile</div>
          <div className="sidenavOptions">Class</div>
          <div className="sidenavOptions">Department</div>
          <div className="sidenavOptions">Contact</div>
          <div className="sidenavOptions" onClick={ this.onLogout.bind(this) }>Logout</div>
        </div>
    </div>
  );
}
}
export default UserDashboard;
