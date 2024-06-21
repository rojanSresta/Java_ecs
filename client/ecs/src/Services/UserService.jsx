const BASE_URL = "http://localhost:8080";

const userService = {
  getAllProduct: async () => {
    try {
      const response = await fetch(`${BASE_URL}/product/list`, {
        method: "GET",
        headers: {
          "Content-type": "application/json",
        },
      });
      const data = await response.json();
      return data;
    } catch (error) {
      console.error("Error fetching data:", error);
      throw error;
    }
  },

  getKeysUser: async () => {
    try {
      const response = await fetch(`${BASE_URL}/api/user/id/1`, {
        method: "GET",
        headers: {
          "Content-type": "application/json",
        },
      });
      const keysAndValues = await response.json();
      return keysAndValues;
    } catch (error) {
      console.error("Error fetching parameters", error);
      throw error;
    }
  },

  saveUser: async (formData) => {
    try {
      const response = await fetch(`${BASE_URL}/api/user/save`, {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(formData),
      });
      const data = await response.json();
      return data;
    } catch (error) {
      console.error("Error fetch problem ", error);
      throw error;
    }
  },

  LoginByEmailAndPass: async (loginData) => {
    try {
      const response = await fetch(`${BASE_URL}/api/user/email`, {
        method: "POST",
        headers: {
          "Content-type": "application.json",
        },
        body: JSON.stringify(loginData),
      });
      const data = await response.json();
      return data;
    } catch (error) {
      console.error("Error ", error);
      throw error;
    }
  },
};

export default userService;
