import java.util.Scanner;

class ATM {
    private double balance;
    private final String pin = "1234"; // dummy pin

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposit successful. New balance: $%.2f%n", balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", balance);
        }
    }
}

public class Task3_ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1000.00); // starting balance

        System.out.print("Enter your 4-digit PIN: ");
        String enteredPin = sc.nextLine().trim();

        if (!atm.validatePin(enteredPin)) {
            System.out.println("Incorrect PIN. Access denied.");
            sc.close();
            return;
        }

        System.out.println("PIN accepted. Welcome!");
        boolean running = true;

        while (running) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    atm.checkBalance();
                    break;
                case "2":
                    System.out.print("Enter amount to deposit: ");
                    double dep = Double.parseDouble(sc.nextLine().trim());
                    atm.deposit(dep);
                    break;
                case "3":
                    System.out.print("Enter amount to withdraw: ");
                    double wd = Double.parseDouble(sc.nextLine().trim());
                    atm.withdraw(wd);
                    break;
                case "4":
                    running = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}
