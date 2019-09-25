import React from 'react';
import AddUser from './Module/User/AddUser';
import Login from './Module/Login/Login';
import UserDashboard from './Module/User/UserDashboard';
import {Switch, Route} from 'react-router-dom';

class App extends React.Component {

render() {
  return (
    <div className="App">
      <Switch >
        <Route exact path = "/" component = {Login} />
        <Route path = "/adduser" component = {AddUser} />
        <Route path = "/userdashboard" component={UserDashboard} />
      </Switch>
    </div>
  );
}
}
export default App;
