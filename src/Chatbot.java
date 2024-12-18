import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Chatbot {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, String> responseMap = new HashMap<>();
    private String lastTopic = "";

    public Chatbot() {
        initializeResponses();
    }

    private void initializeResponses() {
        responseMap.put("database", "You can add a new database by going to the Admin Dashboard > Add Database.");
        responseMap.put("error", "Please make sure all fields are correctly filled and try again.");
        responseMap.put("support", "You can contact support by emailing aoa237@student.aru.ac.uk.");
        responseMap.put("help", responseMap.get("support"));
        responseMap.put("performance", "If you're experiencing performance issues, please check the system resources and network connectivity.");
        responseMap.put("crash", "If the application is freezing or crashing, consider updating your software or restarting your system.");
    }

    public void startInteraction() {
        System.out.println("Hello! I'm your assistant. How can I help you today? Type 'exit' anytime to end this conversation.");
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Assistant: Thank you for using the assistant. Goodbye!");
                break;
            }
            respondToQuery(input);
        }
    }

    private void respondToQuery(String query) {
        String lowerCaseQuery = query.toLowerCase();

        if (Pattern.matches(".*how.*|.*what.*|.*where.*|.*when.*|.*why.*", lowerCaseQuery)) {
            handleComplexQuestions(lowerCaseQuery);
        } else {
            genericResponse(lowerCaseQuery);
        }
    }

    private void handleComplexQuestions(String query) {
        Matcher m = Pattern.compile("(how|what|where|when|why)(.*)").matcher(query);
        if (m.find()) {
            String topic = m.group(2).trim();
            lastTopic = topic;
            if (!topic.isEmpty() && responseMap.containsKey(topic)) {
                System.out.println("Assistant: " + responseMap.get(topic));
            } else {
                suggestHelp();
            }
        } else {
            suggestHelp();
        }
    }

    private void genericResponse(String query) {
        for (String key : responseMap.keySet()) {
            if (query.contains(key)) {
                System.out.println("Assistant: " + responseMap.get(key));
                return;
            }
        }
        System.out.println("Assistant: I'm sorry, I don't understand. Can you try asking something else?");
    }

    private void suggestHelp() {
        if (!lastTopic.isEmpty()) {
            System.out.println("Assistant: I noticed you were asking about " + lastTopic + " before. Would you like more information on that?");
        } else {
            System.out.println("Assistant: I'm not sure how to help with that. Could you please provide more details or ask about something else?");
        }
    }
}