import axios from "axios";
import { useState } from "react";
import { Route, Router } from "react-router-dom";
import Login from "./Login";
import UserDetail from "./UserDetail";

function App() {
  const resetCredential = {
    userName: "",
    password: "",
  };
  const [loginRequest, setLoginRequest] = useState(resetCredential);

  const loggedOutUser = {
    userName: null,
    firstName: null,
    lastName: null,
    occupation: null,
    errorMessage: null,
  };
  const [user, setUser] = useState(loggedOutUser);

  function handUserNameInput(e) {
    setLoginRequest({
      userName: e.target.value,
      password: loginRequest.password,
    });
  }

  function handPasswordInput(e) {
    setLoginRequest({
      password: e.target.value,
      userName: loginRequest.userName,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();
    const url = "http://localhost:8080/api/login";
    axios
      .post(url, {
        userName: loginRequest.userName,
        password: loginRequest.password,
      })
      .then((response) => {
        setUser({
          userName: response.data.userName,
          firstName: response.data.firstName,
          lastName: response.data.lastName,
          occupation: response.data.occupation,
        });
      })
      .catch((error) => {
        setUser({
          ...user,
          errorMessage:
            "Your user name or password didn't match. Please try again.",
        });
      });
  }

  function handeLogout(e) {
    e.preventDefault();
    setUser(loggedOutUser);
    setLoginRequest(resetCredential);
  }

  let content = null;

  // user not loged in yet.
  if (!user || user.firstName) {

    content = (
      <Login
        handleSubmit={handleSubmit}
        loginRequest={loginRequest}
        handUserNameInput={handUserNameInput}
        handPasswordInput={handPasswordInput}
        user={user}
      />
    );

  } else {
    content = <UserDetail user={user} handeLogout={handeLogout} />;
  }

return <div>{content}</div>;
}

export default App;
