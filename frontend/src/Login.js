import React, { Component } from "react";

function Login(prope) {
  return (
    <div className="p-10 py-20 w-full justify-center flex">
      <form onSubmit={prope.handleSubmit}>
        <label className="block text-gray-700 text-sm font-bold mb-2 py-3">
          User name
          <input
            type="text"
            value={prope.loginRequest.userName}
            name="userName"
            onChange={prope.handUserNameInput}
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="Username"
          />
        </label>
        <label className="block text-gray-700 text-sm font-bold mb-2 py-3">
          Password
          <input
            type="password"
            value={prope.loginRequest.password}
            onChange={prope.handPasswordInput}
            className="shadow appearance-none  rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="**********"
          />
        </label>
        <input
          type="submit"
          value="login"
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
        />
        <div className="py-3">
          <p class="text-red-500 text-xs italic">{prope.user.errorMessage}</p>
        </div>
      </form>

      <div className="bottom-0 bg-gray-500 w-full absolute justify-center flex">
        <p className="text-center text-center text-xs  bottom-0">
          &copy;2020 simple login demo.
        </p>
      </div>
    </div>
  );
}

export default Login;
