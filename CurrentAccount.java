public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountHolder, double initialBalance, double overdraftLimit) {
        super(accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) balance -= amount;
    }

    public double getOverdraftLimit() { return overdraftLimit; }

    @Override
    public String toString() {
        return super.toString() + ", OverdraftLimit: $" + overdraftLimit;
    }
}
