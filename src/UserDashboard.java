import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDashboard {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\nUser Dashboard");
            System.out.println("1. Server 1");
            System.out.println("2. Server 2");
            System.out.println("3. Server 3");
            System.out.println("4. View Databases");
            System.out.println("5. Sign Out");
            System.out.print("Select an option: ");

            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        new ServerScreen("Server 1").display();
                        break;
                    case 2:
                        new ServerScreen("Server 2").display();
                        break;
                    case 3:
                        new ServerScreen("Server 3").display();
                        break;
                    case 4:
                        new DatabaseSearchScreen().display();
                        break;
                    case 5:
                        System.out.println("Signing out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a valid number from the options.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (option != 5);
    }
}