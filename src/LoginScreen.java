import java.util.InputMismatchException;

public class LoginScreen {

    public void display() {
        System.out.println("Login Screen");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Chat with Support Bot");
        handleLogin();
    }

    private void handleLogin() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int userType = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter login type (1 for Admin, 2 for User, 3 for Support): ");
            try {
                userType = scanner.nextInt();
                switch (userType) {
                    case 1:
                        new AdminDashboard().display();
                        valid = true;
                        break;
                    case 2:
                        new UserDashboard().display();
                        valid = true;
                        break;
                    case 3:
                        new Chatbot().startInteraction();
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter 1, 2, or 3.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("That's not a valid choice! Please enter a number (1, 2, or 3).");
                scanner.next();
            }
        }
    }
}