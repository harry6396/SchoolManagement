import React from 'react';
import './UserDashboard.css';

class UserDashboard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: ''
    };
}

render() {
  return (
    <div className="header">
      <div className="sidenav">
          <a>Profile</a>
          <a>Class</a>
          <a>Department</a>
          <a>Contact</a>
        </div>
    </div>
  );
}
}
export default UserDashboard;
