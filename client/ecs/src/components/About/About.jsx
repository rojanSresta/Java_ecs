import "./About.css";
const About = () => {
  return (
    <div className="w-9/12 m-auto">
      <h2 className="text-2xl mx-3 my-4 text-center font-medium">About us</h2>
      <div className="flex">
        <img src="about.jpg" alt="About" id="aboutImage" className="mx-3" />
        <p className="text-xl mx-3">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Magni dolorum
          iure laboriosam veritatis est alias quae nesciunt dolores labore, quos
          animi eius asperiores maiores et ipsum error distinctio quam voluptate
          illum mollitia? Officiis eaque pariatur magnam dolor soluta, possimus,
          velit ducimus omnis dignissimos quam in magni! Dolorem error labore
          nulla?
        </p>
      </div>
    </div>
  );
};

export default About;
