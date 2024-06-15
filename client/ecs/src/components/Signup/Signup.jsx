import { useEffect, useState } from "react";
import "./Signup.css";
import userService from "../../Services/UserService";
import Login from "../Login/Login";

const Signup = () => {
  const [keys, setKeys] = useState([]);
  const [formData, setFormData] = useState({});

  useEffect(() => {
    async function fetchKeys() {
      try {
        const response = await userService.getKeysUser();
        const keysAndValues = response.data;
        let unmodifiedKeys = [];
        let modifiedKeys = [];
        unmodifiedKeys = Object.keys(keysAndValues);
        unmodifiedKeys = unmodifiedKeys.filter(
          (key) => key.toLowerCase() !== "id"
        );
        modifiedKeys = unmodifiedKeys.map(
          (key) => key[0].toUpperCase() + key.slice(1)
        );
        setKeys(modifiedKeys);
      } catch (error) {
        console.error("Fetch error occured, ", error);
      }
    }
    fetchKeys();
    return () => {};
  }, []);

  const getInputType = (key) => {
    switch (key.toLowerCase()) {
      case "email":
        return "email";
      case "password":
        return "password";
      case "contact":
        return "number";
      case "role":
        return "number";
      default:
        return "text";
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await userService.saveUser(formData);
      if (response) {
        <Login />;
      }
    } catch (error) {
      console.error("Error, ", error);
    }
  };

  return (
    <div className="signup mb-4">
      <h2 className="text-2xl font-serif font-semibold">Register</h2>
      <form onSubmit={handleSubmit}>
        {keys.map((key) => (
          <div key={key} className="form-floating mb-3">
            <input
              type={getInputType(key)}
              name={key.toLowerCase()}
              className="form-control"
              placeholder={key}
              onChange={handleChange}
              required
            />
            <label htmlFor="floatingInput">{key}</label>
          </div>
        ))}
        <div className="flex justify-end">
          <input
            className="bg-teal-500 text-gray-100 p-2 font-serif rounded-md hover:text-black hover:bg-green-400"
            type="submit"
            value={"Submit"}
          />
        </div>
      </form>
    </div>
  );
};

export default Signup;
