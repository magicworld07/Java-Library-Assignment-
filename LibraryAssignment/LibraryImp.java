
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;

public class LibraryImp implements LibraryInterface {
    public static final String RED = "\u001B[31m"; // ANSI color codes
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\u001B[0m";
    public static final String FILE_NAME = "library.txt";
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();
    List<Book> books = new ArrayList<>();



    // Load books from the text file
    public void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookDetails = line.split(",");
                if (bookDetails.length == 4) {
                    books.add(new Book(bookDetails[0], bookDetails[1], bookDetails[2], bookDetails[3]));
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "Error loading books from file." + RESET);
        }
    }

    // Save books to the text file
    public void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(RED + "Error saving books to file." + RESET);
        }
    }

    public void addBook() {
        String bookIsbn = validator.validateIsbn();

        String Title = validator.validateAuthorTitle("Title");
        String Author = validator.validateAuthorTitle("Author");
        Book book = new Book(bookIsbn, Title, Author, "Available");
        books.add(book);
        saveBooksToFile();

        System.out.println(GREEN + "Book Added Successfully!!!" + RESET);

    }

    public void borrowBook() {
        String bookIsbn = validator.validateIsbn();
        boolean flag = false;
        for (Book book : books) {
            if (book.getIsbn().equals(bookIsbn) && book.getStatus().equals("Available")) {
                flag = true;
                saveBooksToFile();
                System.out.println(GREEN + "Book Borrowed Successfully!!!!" + RESET);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Detail:" + book);
            }
        }

        if (flag == false)
            System.out.println(RED + "This book is not Available to Borrow" + RESET);
    }

    public void returnBook() {
        boolean flag = false;
        String bookIsbn = validator.validateIsbn();
        for (Book book : books) {
            if (book.getIsbn().equals(bookIsbn) && book.getStatus().equals("Not Available")) {
                flag = true;
                saveBooksToFile();
                System.out.println(GREEN + "Book Returned Successfully!!!" + RESET);
                book.setStatus("Available");
                System.out.println("Returned Book Detail:" + book);

            }
        }
        if (flag == false)
            System.out.println(RED + "we cannot return this book" + RESET);

    }

    public void showAllBooks() {
        boolean flag = false;
        System.out.println("\n--------------------------------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s", "ISBN", "Title", "Author", "Status" + RESET);
        System.out.println("\n--------------------------------------------------");
        for (Book book : books) {
            System.out.format("%s%15s%15s%15s", book.getIsbn(), book.getTitle(), book.getAuthor(), book.getStatus());
            System.out.println();
            flag = true;
        }
        System.out.println("\n--------------------------------------------------");
        if (flag == false)
            System.out.println(RED + "There is no book in Library " + RESET);
    }
}
