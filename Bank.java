import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Account createSavingsAccount(String holder, double balance, double interest) {
        SavingsAccount acc = new SavingsAccount(holder, balance, interest);
        accounts.add(acc);
        return acc;
    }

    public Account createCurrentAccount(String holder, double balance, double overdraft) {
        CurrentAccount acc = new CurrentAccount(holder, balance, overdraft);
        accounts.add(acc);
        return acc;
    }

    public Account findAccount(long id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public void transfer(long fromId, long toId, double amount) {
        Account sender = findAccount(fromId);
        Account receiver = findAccount(toId);
        if (sender != null && receiver != null) {
            sender.withdraw(amount);
            receiver.deposit(amount);
        }
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
}
