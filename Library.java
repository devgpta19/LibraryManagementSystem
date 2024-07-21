import java.io.*;
import java.util.*;

public class Library{
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public Book searchByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>(books.values());
        Collections.sort(bookList, Comparator.comparing(Book::getTitle));
        return bookList;
    }

    public void saveLibrary(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
        }
    }

    public void loadLibrary(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            books = (HashMap<String, Book>) ois.readObject();
        }
    }
}
