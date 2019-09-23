import React from 'react';
import './Login.css';
import {Router} from 'react-router-dom';

class LoginUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: '',
      password: ''
    };
    this.submitData = this.submitData.bind(this);
    this.redirectOnSubmit = this.redirectOnSubmit.bind(this);
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
}

handleEmailChange(event) {
  this.setState({ userName: event.target.value });
}

handlePasswordChange(event) {
  this.setState({ password: event.target.value });
}

submitData() {
  fetch("http://localhost:8080/schoolmanagement/login?key=SHARED_KEY",{
    headers: {
      'Accept': 'application/json, text/plain, */*',
      'Content-Type': 'application/json'
    },
    method: "POST",
    body: JSON.stringify({"userId":this.state.userName,"userPassword":this.state.password})
  })
    .then(res => res.json())
    .then(
      (result) => {
        if(result.message === "Success"){
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
              <input className="inputField" type="text" placeholder="Enter username" onChange={this.handleEmailChange}/>
          </div>
        </div>
        <div >
          <div className="passWord display-inline">
            Password
          </div>
          <div className="display-inline">
            <input className="inputField" type="password" placeholder="Enter password" onChange={this.handlePasswordChange}/>
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
