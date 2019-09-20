import React from 'react';
var a = "hello";
class AddUser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: '<div><input type=\"text\"/></div><div className=\"submitButton\">Submit</div>'
    };
}

render() {
  return (
    <div className="header">
      <div dangerouslySetInnerHTML={{ __html: this.state.items }} />
      {a}
    </div>
  );
}
}
export default AddUser;
