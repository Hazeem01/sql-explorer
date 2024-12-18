import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDatabaseScreen {

    public void display() {
        System.out.println("Remove Database Screen");
        List<String> databases = new ArrayList<>();
        try {
            databases = readDatabasesFromFile();
            for (int i = 0; i < databases.size(); i++) {
                System.out.println((i + 1) + ". " + databases.get(i));
            }

            System.out.print("Enter database to remove: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice < 1 || choice > databases.size()) {
                System.out.println("Invalid option.");
            } else {
                System.out.println("Database removed successfully.");
            }
        } catch (IOException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
        }
    }

    private List<String> readDatabasesFromFile() throws IOException {
        List<String> databases = new ArrayList<>();
        Scanner scanner = new Scanner(new File("databases.txt"));
        while (scanner.hasNextLine()) {
            databases.add(scanner.nextLine());
        }
        scanner.close();
        return databases;
    }
}