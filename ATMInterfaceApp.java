import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Amount withdrawn successfully.");
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", balance);
    }

    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
       try (Scanner scanner = new Scanner(System.in)){
        int choice;

        do {
            System.out.println("\n=====================");
            System.out.println("🏧 ATM INTERFACE MENU");
            System.out.println("=====================");
            System.out.println("1. 💸 Withdraw");
            System.out.println("2. 💰 Deposit");
            System.out.println("3. 📊 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("👉 Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1->{
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                }

                case 2->{
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                }

                case 3->{
                    account.checkBalance();
                    break;
                }

                case 4->{
                    System.out.println("🔒 Thank you for using the ATM. Have a Nice Day!");
                    break;
                }

                default->
                    System.out.println("❌ Invalid choice. Please select 1 to 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

    public BankAccount getAccount() {
        return account;
    }
}

// Main class
public class ATMInterfaceApp {
    public static void main(String[] args) {
        // Step 1: Create a BankAccount object with an initial balance
        BankAccount userAccount = new BankAccount(1000.00);  // Initial balance ₹1000

        // Step 2: Pass the account to the ATM and start the interface
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}