import java.util.Scanner; //Import the Scanner Class


public class Main {
    public static final String RED = "\u001B[31m"; // ANSI color codes
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);
        LibraryInterface service = new LibraryImp();

        do {
            System.out.println("Welcome to the Library Book Management System");
            System.out.println("Menu:");
            System.out.println(
                    "1: Add Book\n" + "2: Borrow Book\n" + "3: Return Book\n" + "4: Show All Books\n" + "5: Exit");
            System.out.println("Enter your choice:");

            choice = scan.nextInt();
            switch (choice) {
                case 1: {

                    service.addBook();
                    break;
                }
                case 2: {
                    service.borrowBook();
                    break;
                }
                case 3: {
                    service.returnBook();
                    break;
                }
                case 4: {
                    service.showAllBooks();
                    break;
                }
                case 5: {
                    System.out.println(BLUE+"Thank you for Using Application !!"+RESET);
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println(RED+"Invalid choice. Please try again"+RESET);
                }
            }
        } while (choice != 5);
        scan.close();

    }

}
