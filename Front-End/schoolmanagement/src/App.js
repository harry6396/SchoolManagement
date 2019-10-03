import React from 'react';
import AddUser from './Module/User/AddUser';
import Login from './Module/Login/Login';
import UserDashboard from './Module/User/UserDashboard';
import {BrowserRouter as Router, Route} from 'react-router-dom';

class App extends React.Component {

render() {
  return (
        <Router>
        <div className="App">
        <Route exact path = "/" component = {Login} />
        <Route path = "/adduser" component = {AddUser} />
        <Route path = "/userdashboard" component={UserDashboard} />
        </div>
        </Router>
  );
}
}
export default App;
