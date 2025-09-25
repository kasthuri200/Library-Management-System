import java.util.ArrayList;
import java.util.List;

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

// User Class
class User {
    private String name;
    private int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

// Library Class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String title, int userId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book '" + title + "' issued to user ID " + userId);
                return;
            }
        }
        System.out.println("Book not available or already issued!");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book '" + title + "' returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return! Book not found or not issued.");
    }
}

// Main Class
public class LibraryManagementSystems {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Python Fundamentals", "Guido van Rossum"));
        library.addBook(new Book("C++ Guide", "Bjarne Stroustrup"));

        // Add users
        library.addUser(new User(1, "Ravi"));
        library.addUser(new User(2, "Priya"));

        // Show books
        library.showBooks();

        // Issue a book
        library.issueBook("Java Basics", 1);

        // Show books again
        library.showBooks();

        // Return a book
        library.returnBook("Java Basics");

        // Final list
        library.showBooks();
    }
}

