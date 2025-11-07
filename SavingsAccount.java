public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * (interestRate / 100);
    }

    public double getInterestRate() { return interestRate; }

    @Override
    public String toString() {
        return super.toString() + ", InterestRate: " + interestRate + "%";
    }
}
