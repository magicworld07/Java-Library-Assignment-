public class Book {

    private String isbn;
    private String title;
    private String author; // properties
    private String status;

    public Book() { // constructor

    }

    Book(String isbn, String title, String author , String status) // Constuctor with Parameters
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;        
        this.status = status;

    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() // getters and setters methods
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString Method
    public String toString() {
        return "Book{Isbn: '" + isbn + "', Title: '" + title + "', Author: '" + author + "',Status: '" + status
                + "'  }";
    }
}
