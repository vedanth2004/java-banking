import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Add Interest (Savings)");
            System.out.println("7. View All Accounts");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Interest Rate %: ");
                    double rate = sc.nextDouble();
                    Account acc = bank.createSavingsAccount(name, balance, rate);
                    System.out.println("Created: " + acc);
                }
                case 2 -> {
                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Overdraft Limit: ");
                    double overdraft = sc.nextDouble();
                    Account acc = bank.createCurrentAccount(name, balance, overdraft);
                    System.out.println("Created: " + acc);
                }
                case 3 -> {
                    System.out.print("Account ID: ");
                    long id = sc.nextLong();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    Account acc = bank.findAccount(id);
                    if (acc != null) {
                        acc.deposit(amt);
                        System.out.println("Deposited. New Balance: " + acc.getBalance());
                    } else System.out.println("Account not found");
                }
                case 4 -> {
                    System.out.print("Account ID: ");
                    long id = sc.nextLong();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    Account acc = bank.findAccount(id);
                    if (acc != null) {
                        acc.withdraw(amt);
                        System.out.println("Withdrawn. New Balance: " + acc.getBalance());
                    } else System.out.println("Account not found");
                }
                case 5 -> {
                    System.out.print("From Account ID: ");
                    long from = sc.nextLong();
                    System.out.print("To Account ID: ");
                    long to = sc.nextLong();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bank.transfer(from, to, amt);
                    System.out.println("Transfer completed.");
                }
                case 6 -> {
                    System.out.print("Savings Account ID: ");
                    long id = sc.nextLong();
                    Account acc = bank.findAccount(id);
                    if (acc instanceof SavingsAccount sa) {
                        sa.addInterest();
                        System.out.println("Interest Added. New Balance: " + sa.getBalance());
                    } else System.out.println("Not a savings account");
                }
                case 7 -> {
                    System.out.println("--- All Accounts ---");
                    for (Account acc : bank.getAllAccounts()) System.out.println(acc);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
