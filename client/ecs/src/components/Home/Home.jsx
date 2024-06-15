import { useEffect, useState } from "react";
import userService from "../../Services/UserService";
import "../Home/Home.css";

const Home = () => {
  const [productData, setProductData] = useState([]);

  useEffect(() => {
    async function fetchProductData() {
      try {
        const responseData = await userService.getAllProduct();
        setProductData(responseData.data);
      } catch (error) {
        console.error("Error Fetching Products, ", error);
      }
    }
    fetchProductData();

    return () => {};
  }, []);

  return (
    <>
      <div>
        <h2 className="text-3xl text-center my-4">Buy What You Need</h2>
      </div>
      <div>
        <ul className="flex mx-40 my-8">
          {productData.map((product) => (
            <li className="mx-8" key={product.proId}>
              <div className="card">
                <img src={product.imageUrl} alt={product.proName} />
                <div className="productDetails flex flex-col items-center text-xl">
                  <p className="font-serif">{product.proName}</p>
                  <div className="price bg-teal-500 text-gray-100 w-full flex justify-center hover:text-teal-500 hover:bg-gray-300">
                    <button className="font-mono">${product.price}</button>
                  </div>
                </div>
              </div>
            </li>
          ))}
        </ul>
      </div>
    </>
  );
};

export default Home;
