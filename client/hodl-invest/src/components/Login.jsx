import React, {Component} from 'react';
import ReactSignupLoginComponent from 'react-signup-login-component';
import './Login.css';

const LoginPage = (props) => {
  const signupWasClickedCallback = (data) => {
    console.log(data);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "https://hodl-invest-server.herokuapp.com/api/v1/users/", true);
    xhr.send(data);
    console.log(xhr.status);
    alert('Signup Successful');
  };
  const loginWasClickedCallback = (data) => {
    console.log(data);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "https://hodl-invest-server.herokuapp.com/api/v1/users/login", true);
    xhr.setRequestHeader("content-type", "application/json");
    xhr.setRequestHeader("cache-control", "no-cache");

    xhr.send(data);
    alert('Login Successful');
  };
  /*const recoverPasswordWasClickedCallback = (data) => {
    console.log(data);
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "https://hodl-invest-server.herokuapp.com/api/v1/users/", false);
    xhr.setRequestHeader("content-type", "application/json");
    xhr.setRequestHeader("cache-control", "no-cache");

    xhr.send();
    var correctindex=-1;
    var userstring=xhr.responseText;
    var JSONTWO= JSON.parse(userstring);
    for(i=0;i<JSONTWO.length;i++){
    if(JSONTWO[i].username==data.username){
    correctindex=i;}}
    }
    alert('Recover password callback, see log on the console to see the data. testing');*/

  return (
    <div>
    <ReactSignupLoginComponent
    styles={{
      mainWrapper: { backgroundColor: '#2892D7' },
      mainTitle: { color: 'white' },
      flipper: { transition: '0.1s' },
      signup: {
        wrapper: { backgroundColor: 'yellow' },
        inputWrapper: { backgroundColor: '#53a7df' },
        buttonsWrapper: { backgroundColor: '#53a7df' },
        input: { backgroundColor: 'LavenderBlush' },
        recoverPassword: {},
        button: { backgroundColor: 'LavenderBlush' },
      },
      login: {
        wrapper: { backgroundColor: 'yellow' },
        inputWrapper: { backgroundColor: '#53a7df' },
        buttonsWrapper: { backgroundColor: '#53a7df' },
        input: { backgroundColor: 'LavenderBlush' },
        recoverPasswordWrapper: { backgroundColor: '#53a7df' },
        recoverPasswordButton: { backgroundColor: 'LavenderBlush' },
        button: { backgroundColor: 'LavenderBlush' },
      }
      /*recoverPassword: {
        wrapper: { backgroundColor: 'yellow' },
        inputWrapper: { backgroundColor: '#53a7df' },
        buttonsWrapper: { backgroundColor: '#53a7df' },
        input: { backgroundColor: 'LavenderBlush' },
        button: { backgroundColor: 'LavenderBlush' },
      }*/
    }}
    title="Hodl Invest"
    handleSignup={signupWasClickedCallback}
    handleLogin={loginWasClickedCallback}
   // handleRecoverPassword={recoverPasswordWasClickedCallback}
    />
    </div>
  );
};

export default LoginPage;
