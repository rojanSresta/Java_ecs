import { Link, Outlet } from "react-router-dom";
import "./Navbar.css";

const NavbarComponent = () => {
  const handleActive = (event) => {
    const elements = document.getElementsByClassName(`navItems`);
    for (const element of elements) {
      element.classList.remove("activeNav");
    }
    event.target.classList.add("activeNav");
  };

  return (
    <>
      <nav className="flex bg-slate-100 justify-around px-4 py-4">
        <h2 className="font-bold text-2xl">
          <Link to={"/"}>ECS</Link>
        </h2>
        <ul className="flex">
          <Link to="/" className="mx-4 navItems active" onClick={handleActive}>
            Home
          </Link>
          <Link to="/about" className="mx-4 navItems" onClick={handleActive}>
            About
          </Link>
          <Link to="/contact" className="mx-4 navItems" onClick={handleActive}>
            Contact
          </Link>
          <Link to="/login" className="mx-4 navItems" onClick={handleActive}>
            Login
          </Link>
          <Link to="/signup" className="mx-4 navItems" onClick={handleActive}>
            Signup
          </Link>
        </ul>
      </nav>
      <Outlet />
    </>
  );
};

export default NavbarComponent;
