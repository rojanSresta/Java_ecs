const Contact = () => {
  return (
    <div className="my-10">
      <h2 className="text-2xl text-center font-semibold">Contact us</h2>
      <div className="flex">
        <img src="contact.png" alt="Contact" />
        <ul className="flex flex-col justify-center text-xl font-medium">
          <li>Number: 123456789</li>
          <li>Address: ABC-123</li>
        </ul>
      </div>
    </div>
  );
};

export default Contact;
