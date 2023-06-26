const quoteForm = document.getElementById("createQuote-from");

function createQuotes() {
  const token = localStorage.getItem("token");

    quoteForm.addEventListener("submit", async (event) => {
        event.preventDefault();

        const author = document.getElementById("author").value;
        const quote = document.getElementById("quote").value;

        const data = {
            author: author,
            quote: quote
        };
        try {
            const response = await fetch(
                "http://localhost:8080/quote/create",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: `Bearer ${token}`,
                      },
                    body: JSON.stringify(data),
                }
            );

            if (response.ok) {
                alert("You created a new quote");
                window.location.assign("quotes.html");
            } else {
                const responseData = await response.json();
                alert(responseData.error);
            }
        } catch (error) {
            console.error(error);
            alert("an error ocurred. Try again Later")
        }
    });
}
