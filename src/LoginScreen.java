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
        System.out.print("Enter login type (1 for Admin, 2 for User, 3 for Support): ");
        int userType = scanner.nextInt();

        switch (userType) {
            case 1:
                new AdminDashboard().display();
                break;
            case 2:
                new UserDashboard().display();
                break;
            case 3:
                new Chatbot().startInteraction();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                this.display();
        }
    }
}