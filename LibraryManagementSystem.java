import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(String bookId, Book book) {
        books.put(bookId, book);
    }

    public Book findBook(String bookId) {
        return books.get(bookId);
    }

    public void borrowBook(String bookId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid book or book is already available.");
        }
    }

    public void printAvailableBooks() {
        System.out.println("Available Books:");
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            String bookId = entry.getKey();
            Book book = entry.getValue();
            if (book.isAvailable()) {
                System.out.println("Book ID: " + bookId + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add books to the library
        library.addBook("B001", new Book("The India Story", "Bimal Jalal "));
        library.addBook("B002", new Book("Python Basics", "Jane Doe"));
        library.addBook("B003", new Book("A Place Called Home", "Preeti Shenoy"));
        library.addBook("B004", new Book("Queen Of Fire", "Devika Rangachari"));
        library.addBook("B005", new Book("Hear yourself", "prem Rawat"));

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Show Available Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;
                case 2:
                    System.out.print("Enter book ID to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;
                case 3:
                    library.printAvailableBooks();
                    break;
                case 4:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
