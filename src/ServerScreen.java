import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServerScreen {
    private String serverID;

    public ServerScreen(String serverID) {
        this.serverID = serverID;
    }

    public void display() {
        System.out.println(serverID + " Details Screen");
        System.out.println("Displaying databases located on " + serverID + ":");
        try {
            displayDatabasesForServer();
        } catch (IOException e) {
            System.out.println("Error reading database information: " + e.getMessage());
        }
    }

    private void displayDatabasesForServer() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("databases.txt"));
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Server: " + serverID)) {
                found = true;
                System.out.println("\nDatabase Details:");
                do {
                    System.out.println(line);
                    line = reader.readLine();
                } while (line != null && !line.isEmpty());
                System.out.println("--------------------------------------------------");
            }
        }
        reader.close();
        if (!found) {
            System.out.println("No databases are located on " + serverID + ".");
        }
    }
}