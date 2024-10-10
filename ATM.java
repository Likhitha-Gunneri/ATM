import java.util.Scanner;

public class ATM {
    private static double balance = 10000;  // Starting balance
    private static final int PIN = 123;     // Default PIN
    private static String transactionHistory = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for PIN
        System.out.println("Enter ATM Pin: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == PIN) {
            System.out.println("Account Authorized!");
            boolean quit = false;

            // ATM Menu
            while (!quit) {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Ministatement");
                System.out.println("5. Exit");

                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        viewBalance();
                        break;
                    case 2:
                        withdrawAmount(scanner);
                        break;
                    case 3:
                        depositAmount(scanner);
                        break;
                    case 4:
                        viewMiniStatement();
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Exiting. Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN! Exiting...");
        }

        scanner.close();
    }

    // Method to view the current balance
    private static void viewBalance() {
        System.out.printf("Your Current Balance is: %.2f\n", balance);
    }

    // Method to withdraw money
    private static void withdrawAmount(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory += "Withdrawn: " + amount + "\n";
            System.out.println("Collect the Cash " + amount);
        }
        viewBalance();
    }

    // Method to deposit money
    private static void depositAmount(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory += "Deposited: " + amount + "\n";
        System.out.println("Amount Deposited: " + amount);
        viewBalance();
    }

    // Method to view the mini statement
    private static void viewMiniStatement() {
        System.out.println("\nMini Statement:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println(transactionHistory);
        }
    }
}
