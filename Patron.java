import java.util.ArrayList;
import java.util.List;


public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Book> borrowedBooks;
    /**
     * @param name
     * @param address
     * @param phoneNumber
     */
    // Constructor
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>(); // thiss init the list of borrowed books
    }

    // adds a book to the list of borrowed books
    public void borrowBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
        }
    }

    // Removes a book from the list of borrowed books, simulating a return for the video demo
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
