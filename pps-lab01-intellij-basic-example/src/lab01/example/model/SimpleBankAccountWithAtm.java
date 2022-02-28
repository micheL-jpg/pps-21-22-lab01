package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final AccountHolder accountHolder;
    private int balance;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public AccountHolder getHolder() {
        return accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
