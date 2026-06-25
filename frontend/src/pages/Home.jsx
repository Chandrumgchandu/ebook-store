import { useEffect, useState } from "react";
import api from "../services/api";

function Home() {

    const [books, setBooks] = useState([]);

    useEffect(() => {
        api.get("/books")
            .then(response => setBooks(response.data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div style={{padding: "20px"}}>
            <h1>E-Book Store</h1>

            {books.map(book => (
                <div key={book.id}>
                    <h3>{book.title}</h3>
                    <p>Author: {book.author}</p>
                    <p>Price: ₹{book.price}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default Home;