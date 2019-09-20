import React from 'react';
import './Login.css';
import {Router} from 'react-router-dom';

class LoginUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: ""
    };
    this.submitData = this.submitData.bind(this);
    this.redirectOnSubmit = this.redirectOnSubmit.bind(this);
}

submitData() {
  fetch("http://localhost:8080/mavenproject1/webapi/myresource/tokenGenerator")
    .then(res => res.json())
    .then(
      (result) => {
        this.setState({
          isLoaded: true,
          items: result.token
        });
        if(result.token !== null){
          this.redirectOnSubmit();
        }
      }
    )
}

redirectOnSubmit(){
  const { history: { push } } = this.props;
  push('/userdashboard');
}

render() {
  return (
    <div className="schoolName">School Name
      <div className="userDetail">
        <div>
          <div className="userName display-inline">
            Username
          </div>
          <div className="display-inline">
              <input className="inputField" type="text" placeholder="Enter username"/>
          </div>
        </div>
        <div >
          <div className="passWord display-inline">
            Password
          </div>
          <div className="display-inline">
            <input className="inputField" type="password" placeholder="Enter password"/>
          </div>
        </div>
        <div>
          <input className="submitButton" value="Login" type="button" onClick={this.submitData}/>
        </div>
      </div>
      </div>
  );
}
}
export default LoginUser;
