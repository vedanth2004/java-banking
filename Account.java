public class Account {
    private static long nextId = 1;
    protected long id;
    protected String accountHolder;
    protected double balance;

    public Account(String accountHolder, double initialBalance) {
        this.id = nextId++;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public long getId() { return id; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return "ID: " + id + ", Holder: " + accountHolder + ", Balance: $" + balance;
    }
}
