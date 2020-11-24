import React from "react";

function UserDetail(prope) {
  return (
    <div className="p-10 py-20 justify-center w-full">
      <div className="p-3 w-full text-center">
        <h1 className="block text-gray-700 text-xl font-bold mb-2 py-3">
          Welcome {prope.user.userName}!
        </h1>
      </div>
      <div className="p-3 w-full text-center">
        {prope.user.firstName}, {prope.user.lastName}. {prope.user.occupation}
      </div>
      <div className="p-3 w-full text-center">
        <input
          type="submit"
          value="logout"
          onClick={prope.handeLogout}
          className="text-center bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
        />
      </div>
    </div>
  );
}

export default UserDetail;
