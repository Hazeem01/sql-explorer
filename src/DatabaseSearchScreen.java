import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseSearchScreen {

    public void display() {
        System.out.println("Database Server Search Screen");
        System.out.println("Displaying search options with filters");
        System.out.println("Searching and displaying database records...");
        System.out.println();
        try {
            if (!readDatabasesFromFile()) {
                System.out.println("No databases found.");
            }
        } catch (IOException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
        }
    }

    private boolean readDatabasesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("databases.txt"));
        String line;
        boolean foundDatabase = false;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                displayDatabaseDetails(line);
                foundDatabase = true;
            } else {
                System.out.println("--------------------------------------------------");
            }
        }
        reader.close();
        return foundDatabase;
    }

    private void displayDatabaseDetails(String dbDetails) {
        String[] properties = dbDetails.split("\n");
        Map<String, String> dbMap = new LinkedHashMap<>();
        for (String property : properties) {
            String[] keyValue = property.split(": ");
            if (keyValue.length == 2) {
                dbMap.put(keyValue[0], keyValue[1]);
            }
        }

        if (!dbMap.isEmpty()) {
            dbMap.forEach((key, value) -> System.out.println(key + ": " + value));
            System.out.println();
        }
    }
}
