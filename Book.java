public class Book implements Borrowable {
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private Status status; // Assuming Status is an enum with AVAILABLE, CHECKED_OUT, OVERDUE

/**
 * Represents a book in the library.
 */

    // Constructor
    public Book(String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = Status.AVAILABLE; // Initially, a book is available
    }

    // Interface methods implementation
    @Override
    public void borrowBook() {
        if (status == Status.AVAILABLE && numberOfCopies > 0) {
            numberOfCopies--;
            if (numberOfCopies == 0) {
                status = Status.CHECKED_OUT;
            }
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    /**
     * Method to return a book.
     *
     */
    @Override
    public void returnBook() {
        numberOfCopies++;
        status = Status.AVAILABLE; // Assume that a book becomes available as soon as it's returned
        System.out.println("Book returned successfully!");
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param  title   the new title to set
     * @return         void
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the content.
     *
     * @return  the author of the content
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of the object.
     *
     * @param  author  the new author to be set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Retrieves the publisher of the book.
     *
     * @return         the publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
