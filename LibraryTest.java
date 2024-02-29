// Author: Justin Whalen
// Date: 2024/02/28
// Purpose: Test the library system

import java.util.Date;

/**
 * The LibraryTest class is used to test the Library class.
 */
public class LibraryTest {
    public static void main(String[] args) {
        // Initialize the library
        Library library = new Library();

        // Create authors
        Author rowling = new Author("J.K. Rowling", new Date());
        Author orwell = new Author("George Orwell", new Date());
        Author tolkien = new Author("J.R.R. Tolkien", new Date());
        Author martin = new Author("George R.R. Martin", new Date());
        Author lewis = new Author("C.S. Lewis", new Date());
        Author austen = new Author("Jane Austen", new Date());
        Author shakespeare = new Author("William Shakespeare", new Date());
        Author homer = new Author("Homer", new Date());
        Author fitzgerald = new Author("F. Scott Fitzgerald", new Date());
        Author woolf = new Author("Virginia Woolf", new Date());

        // Create books
        Book hp1 = new Book("Harry Potter and the Sorcerer's Stone", rowling, "978-0439708180", "Scholastic", 3);
        Book hp2 = new Book("Harry Potter and the Chamber of Secrets", rowling, "978-0439064873", "Scholastic", 2);
        Book animalFarm = new Book("Animal Farm", orwell, "978-0451526342", "Harcourt Brace", 4);
        Book nineteenEightyFour = new Book("1984", orwell, "978-0451524935", "Plume", 5);
        Book lotr1 = new Book("The Fellowship of the Ring", tolkien, "978-0544003415", "Houghton Mifflin Harcourt", 3);
        Book got = new Book("A Game of Thrones", martin, "978-0553593716", "Bantam", 4);
        Book narnia = new Book("The Chronicles of Narnia", lewis, "978-0066238500", "HarperCollins", 3);
        Book pride = new Book("Pride and Prejudice", austen, "978-0141439518", "Penguin", 4);
        Book hamlet = new Book("Hamlet", shakespeare, "978-0451526922", "Signet", 3);
        Book iliad = new Book("The Iliad", homer, "978-0140275360", "Penguin", 2);

        // Add authors and books to the library
        library.addAuthor(rowling);
        library.addAuthor(orwell);
        library.addAuthor(tolkien);
        library.addAuthor(martin);
        library.addAuthor(lewis);
        library.addAuthor(austen);
        library.addAuthor(shakespeare);
        library.addAuthor(homer);
        library.addAuthor(fitzgerald);
        library.addAuthor(woolf);

        library.addBook(hp1);
        library.addBook(hp2);
        library.addBook(animalFarm);
        library.addBook(nineteenEightyFour);
        library.addBook(lotr1);
        library.addBook(got);
        library.addBook(narnia);
        library.addBook(pride);
        library.addBook(hamlet);
        library.addBook(iliad);

        // Create patrons
        Patron patron1 = new Patron("John Doe", "123 Main St", "555-1234");
        Patron patron2 = new Patron("Jane Smith", "456 Elm St", "555-5678");
        Patron patron3 = new Patron("Alice Johnson", "789 Pine St", "555-9101");

        // Add patrons to the library
        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);

        // Demonstrate borrowing books
        System.out.println("Patrons borrowing books:");
        library.borrowBook(hp1.getISBN(), patron1);
        library.borrowBook(animalFarm.getISBN(), patron2);
        library.borrowBook(lotr1.getISBN(), patron3);
        library.borrowBook(got.getISBN(), patron1);

        // Show current books borrowed by each patron
        System.out.println("\nBooks currently borrowed by patrons:");
        printBorrowedBooks(patron1);
        printBorrowedBooks(patron2);
        printBorrowedBooks(patron3);

        // Returning some books
        System.out.println("\nPatrons returning books:");
        library.returnBook(hp1.getISBN(), patron1);
        library.returnBook(animalFarm.getISBN(), patron2);

        // Attempt to borrow a book that is not available
        System.out.println("\nAttempting to borrow books not available:");
        library.borrowBook(hp1.getISBN(), patron2); // Already borrowed and returned by patron1, should be available now

        // Search for a book by title
        System.out.println("\nSearching for a book by title 'A game of thrones':");
        library.searchBooksByTitle("A Game of Thrones").forEach(book -> System.out.println(book.getTitle() + ", " + book.getISBN()));

        // Search for books by author
        System.out.println("\nSearching for books by author 'J.K. Rowling':");
        library.searchBooksByAuthor("J.K. Rowling").forEach(book -> System.out.println(book.getTitle() + ", " + book.getISBN()));
    }

    private static void printBorrowedBooks(Patron patron) {
        System.out.println(patron.getName() + " has borrowed:");
        patron.getBorrowedBooks().forEach(book -> System.out.println("- " + book.getTitle()));
    }
}
