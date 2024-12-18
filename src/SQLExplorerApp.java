//Student ID: 2320756
//Group Name: Creative Collective
//2nd Live Brief
//Option 2: SQL Explorer

import java.util.*;

public class SQLExplorerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        do {
            System.out.println("\nWelcome to SQL Explorer!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            while (true) {
                try {
                    userInput = scanner.nextInt();
                    if (userInput == 1 || userInput == 2) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 for Login or 2 for Exit.");
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("That's not a valid choice! Please enter 1 or 2.");
                    scanner.next();
                }
                System.out.print("Enter your choice (1 or 2): ");
            }
            if (userInput == 1) {
                new LoginScreen().display();
            }
        } while (userInput != 2);
        System.out.println("Thank you for using SQL Explorer from Creative Collective. Goodbye!");
    }
}