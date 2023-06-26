function goToQuotes() {
  window.location.href = "createQuote.html";
}
function logOut() {
  localStorage.removeItem("token");
  window.location.assign("login.html")
}

function getQuotes() {
  const token = localStorage.getItem("token");
  if(!token) {
    alert('You are not logged in')
    window.location.assign('login.html')
  } else {

  

  fetch("http://localhost:8080/quote/getAllQuote", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`
    }
  })
    .then((response) => response.json())
    .then((data) => {
      const quoteTableBody = document.getElementById("quote-table-body");

      quoteTableBody.innerHTML = "";

      data.forEach((quote) => {
        const row = document.createElement("tr");

        const idCell = document.createElement("td");
        idCell.textContent = quote.id;
        row.appendChild(idCell);

        const authorCell = document.createElement("td");
        authorCell.textContent = quote.author;
        row.appendChild(authorCell);

        const quoteCell = document.createElement("td");
        quoteCell.textContent = quote.quote;
        row.appendChild(quoteCell);

        quoteTableBody.appendChild(row);
      });
    })
    .catch((error) => {
      console.error("Error:", error);
    });
  
  }
}