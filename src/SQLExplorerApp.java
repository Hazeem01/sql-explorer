//Student ID: 2320756
//Group Name: Creative Collective
//2nd Live Brief
//SQL Explorer

import java.util.*;
public class SQLExplorerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            System.out.println("\nWelcome to SQL Explorer!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            userInput = scanner.nextInt();
            if (userInput == 1) {
                new LoginScreen().display();
            }
        } while (userInput != 2);
        System.out.println("Thank you for using (Creative Collective) SQL Explorer from Hazeem. Goodbye!");
    }
}