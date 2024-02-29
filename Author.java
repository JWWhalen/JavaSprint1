import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The Author class represents an author of a book.
 */
public class Author {
    private String name;
    private Date dateOfBirth;
    private List<Book> booksWritten;

    // Constructor
    public Author(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>(); // Initialize the list of books
    }

    // Adds a book to the list of books written by the author
    public void addBook(Book book) {
        if (!booksWritten.contains(book)) {
            booksWritten.add(book);
        }
    }

    // Removes a book from the list of books written by the author
    public void removeBook(Book book) {
        booksWritten.remove(book);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    /**
     * Set the name of the object.
     *
     * @param  name  the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date of birth.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param  dateOfBirth  the date of birth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the list of books written.
     *
     * @return         the list of books written
     */
    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
