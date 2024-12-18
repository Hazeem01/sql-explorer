import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminDashboard {
    public void display() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\nAdmin Dashboard");
            System.out.println("1. Server 1");
            System.out.println("2. Server 2");
            System.out.println("3. Server 3");
            System.out.println("4. Database Search");
            System.out.println("5. Database Menu");
            System.out.println("6. Synchronization");
            System.out.println("7. Add Database");
            System.out.println("8. Remove Database");
            System.out.println("9. Sign Out");
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
                        System.out.println("Database Menu Screen");
                        break;
                    case 6:
                        new SyncScreen().display();
                        break;
                    case 7:
                        new AddDatabaseScreen().display();
                        break;
                    case 8:
                        new RemoveDatabaseScreen().display();
                        break;
                    case 9:
                        System.out.println("Signing out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please select a number from the options displayed.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (option != 9);
    }
}