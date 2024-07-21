import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search for a Book by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Save Library to File");
            System.out.println("6. Load Library from File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    Book book = new Book(title, author, isbn, genre);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    System.out.println("Book removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter title of the book to search: ");
                    String titleToSearch = scanner.nextLine();
                    Book searchedBook = library.searchByTitle(titleToSearch);
                    if (searchedBook != null) {
                        System.out.println("Book found: " + searchedBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    List<Book> allBooks = library.getAllBooks();
                    System.out.println("All Books:");
                    for (Book b : allBooks) {
                        System.out.println(b);
                    }
                    break;
                case 5:
                    System.out.print("Enter filename to save library: ");
                    String saveFilename = scanner.nextLine();
                    try {
                        library.saveLibrary(saveFilename);
                        System.out.println("Library saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Error saving library: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Enter filename to load library: ");
                    String loadFilename = scanner.nextLine();
                    try {
                        library.loadLibrary(loadFilename);
                        System.out.println("Library loaded successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error loading library: " + e.getMessage());
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


