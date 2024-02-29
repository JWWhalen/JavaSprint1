import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Library class represents a library that contains books, authors, and patrons.
 */
public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // ads a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // adds a new author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // adds a new patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // search for books by title
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // search for books by author
    public List<Book> searchBooksByAuthor(String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    // serch for books by ISBN
    public Book searchBooksByISBN(String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    // allows a patron to borrow a book from the library
    public void borrowBook(String ISBN, Patron patron) {
        Book book = searchBooksByISBN(ISBN);
        if (book != null && book.getStatus() == Status.AVAILABLE) {
            book.borrowBook();
            patron.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    // allows a patron to return a book to the library
    public void returnBook(String ISBN, Patron patron) {
        Book book = searchBooksByISBN(ISBN);
        if (book != null) {
            book.returnBook();
            patron.returnBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    // getters and setters for books, authors, and patrons
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Sets the list of books.
     *
     * @param  books  the list of books to be set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Set the list of authors for the object.
     *
     * @param  authors   the list of authors to be set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }
}
