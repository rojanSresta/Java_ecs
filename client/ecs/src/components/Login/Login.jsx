import { useState } from "react";
import userService from "../../Services/UserService";
import "../Login/Login.css";

const Login = () => {
  //creating array of neccessary items needed for login
  // reduces code if some field is needed to be added later
  const attrs = ["email", "password"];
  const [loginData, setLoginData] = useState({});

  //to track all the values typed in the input box
  const handleChange = (e) => {
    const { name, value } = e.target;
    //using spread operator and useState to store the value in the form of object
    setLoginData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    const response = await userService.findUser(loginData);
    console.log(response);
  };

  const labelValue = (value) => {
    //making the names in sentence case i.e. from "email" to "Email"
    return value[0].toUpperCase() + value.slice(1);
  };

  return (
    <div className="login">
      <h1 className="text-2xl mb-3">Login</h1>
      <form onSubmit={handleSubmit}>
        {attrs.map((attr) => (
          <div key={attr} className="form-floating mb-3">
            <input
              type={attr}
              name={attr}
              className="form-control"
              placeholder={attr == "email" ? "example@gmail.com" : attr}
              onChange={handleChange}
              required
            />
            <label htmlFor="floatingInput">{labelValue(attr)}</label>
          </div>
        ))}
        <div className="flex justify-end">
          <input
            className="bg-[#008080] text-gray-100 p-2 font-serif rounded-md hover:text-black hover:bg-[#32CD32]"
            type="submit"
            value={"Submit"}
          />
        </div>
      </form>
    </div>
  );
};

export default Login;
