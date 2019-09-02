import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <div className="schoolName">School Name</div>
      <div className="userDetail">
        <div>
          <div className="userName display-inline">
            Username
          </div>
          <div className="display-inline">
              <input className="inputField" type="text"/>
          </div>
        </div>
        <div >
          <div className="passWord display-inline">
            Password
          </div>
          <div className="display-inline">
            <input className="inputField" type="password"/>
          </div>
        </div>
        <div>
          <input className="submitButton" value="Login" type="button"/>
        </div>
      </div>
    </div>
  );
}

export default App;
