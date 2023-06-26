const form = document.getElementById("register-form");

function registerUser() {
  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const password = document.getElementById("password").value;

    const data = {
      email,
      firstname: firstName,
      lastname: lastName,
      password,
    };

    try {
      const response = await fetch(
        "http://localhost:8080/api/v1/auth/register",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        }
      );

      if (response.ok) {
        alert("Registration successful. Please login to continue.");
        window.location.assign("login.html");
      } else {
        const responseData = await response.json();
        alert(responseData.error);
      }
    } catch (error) {
      console.error(error);
      alert("An error occurred. Please try again later.");
    }
  });
}






