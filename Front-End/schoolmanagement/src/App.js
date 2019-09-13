import React from 'react';
import './App.css';

var a = [{"a":"text"},{"b":"text"}];

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: "jhkjh"
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/mavenproject1/webapi/myresource/tokenGenerator")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result.token
          });
        }
      )
  }

render() {
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
      {this.state.items};
    </div>
  );
}
}
export default App;
