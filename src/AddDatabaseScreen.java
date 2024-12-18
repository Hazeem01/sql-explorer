import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddDatabaseScreen {

    public void display() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Add Database Screen");
        System.out.println("Please choose the destination server:");
        System.out.println("1. Server 1");
        System.out.println("2. Server 2");
        System.out.println("3. Server 3");

        int serverChoice = 0;
        String destinationServer = "";
        while (true) {
            try {
                serverChoice = scanner.nextInt();
                switch (serverChoice) {
                    case 1:
                        destinationServer = "Server 1";
                        break;
                    case 2:
                        destinationServer = "Server 2";
                        break;
                    case 3:
                        destinationServer = "Server 3";
                        break;
                    default:
                        System.out.println("Invalid server choice. Please choose a valid server (1, 2, or 3):");
                        continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid server number (1, 2, or 3).");
                scanner.next();
            }
        }

        scanner.nextLine();
        System.out.print("Database Name: ");
        String databaseName = scanner.nextLine();
        System.out.print("Relationships: ");
        String relationships = scanner.nextLine();
        System.out.print("Indexes: ");
        String indexes = scanner.nextLine();
        System.out.print("Security Protocol: ");
        String securityProtocol = scanner.nextLine();
        System.out.print("Backup Location: ");
        String backupLocation = scanner.nextLine();

        handleAddDatabase(destinationServer, databaseName, relationships, indexes, securityProtocol, backupLocation);
    }

    private void handleAddDatabase(String server, String name, String relationships, String indexes, String security, String backup) {
        if (server.isEmpty() || name.isEmpty()) {
            System.out.println("Error: Missing required fields");
        } else {
            try {
                saveDatabaseToFile(server, name, relationships, indexes, security, backup);
                System.out.println("Database added successfully!");
            } catch (IOException e) {
                System.out.println("Failed to write to file: " + e.getMessage());
            }
        }
    }

    private void saveDatabaseToFile(String server, String name, String relationships, String indexes, String security, String backup) throws IOException {
        String content = String.format("Server: %s\nName: %s\nRelationships: %s\nIndexes: %s\nSecurity: %s\nBackup: %s\n\n",
                server, name, relationships, indexes, security, backup);
        BufferedWriter writer = new BufferedWriter(new FileWriter("databases.txt", true));
        writer.write(content);
        writer.close();
    }
}