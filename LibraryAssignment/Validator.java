import java.util.Scanner; //import the required Classes
import java.util.regex.Pattern;

public class Validator {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m"; // ANSI color codes
    private static Pattern Isbn_Pattern = Pattern.compile("^[a-zA-Z0-9]+$");
    private static Pattern AuthorTitle_pattern = Pattern.compile("^[a-z A-Z]+$");
    Scanner sc = new Scanner(System.in);

    public String validateIsbn() {
        String bookIsbn;
        while (true) {
            System.out.println("Enter ISBN");
            bookIsbn = sc.nextLine();
            if (!Isbn_Pattern.matcher(bookIsbn).matches()) {
                System.out.println(RED + "Sorry! Please Enter Valid ISBN" + RESET);

            } else {
                break;
            }

        }
        return bookIsbn;
    }

    public String validateAuthorTitle(String input) {
        String result;
        while (true) {
            if (input == "Title") {
                System.out.println("Enter Title");

            } else {
                System.out.println("Enter Author");
            }
            result = sc.nextLine();
            if (!AuthorTitle_pattern.matcher(result).matches()) {
                System.out.println(RED + "Please Enter Valid Input" + RESET);
            } else {
                break;
            }
        }
        return result;
    }
}
