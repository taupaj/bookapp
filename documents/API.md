## APIs

* API for creating a new author
  - /api/author 
  - POST 
  - createAuthor
* API for author data editing
  - /api/author 
  - PUT 
  - updateAuthor
* API for getting all users how are authors 
  - /api/author/page 
  - GET 
  - getAllAuthors
* API for creating a new book
  - /api/book
  - POST
  - createBook
* API for book data editing
  - /api/book
  - PUT
  - updateBook  
* API for getting all published books
  - /api/book/page
  - GET
  - getAllBooks
* API for authors to change status of book to publish
  - /api/book/status/publish/{id}
  - PUT
  - publishBook  
* API for getting all authors with published books (with filters)
  - /api/authors-and-books/authors/page
  - GET
  - getAllAuthorsWithBooks
* API for getting all published books (with filters)
  - /api/authors-and-books/books/page
  - GET
  - getAllBooks
