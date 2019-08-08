import React, { Component } from 'react';
import axios from 'axios';
import SignUp from './SingUp';

class App extends Component {
  state = {
    data: null
  };
  getPost = async () => {
    try {
      const response = await axios.get('/api/hello');
      console.log(response)
      this.setState({
        data: response.data
      });
    } catch (e) {
      console.log(e);
    }
  };
  componentDidMount() {
    this.getPost();
  }
  render() {
    if (!this.state.data) {
      return <div>로딩중...</div>;
    }
    const { title, body } = this.state.data;

    return (
      <div>
        <h1>{title}</h1>
        <p>{body}</p>
        <SignUp/>
      </div>
    );
  }
}

export default App;