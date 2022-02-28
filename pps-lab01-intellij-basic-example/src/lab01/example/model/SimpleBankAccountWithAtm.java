package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private final AccountHolder accountHolder;
    private int balance;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    private boolean checkId(int id) {
        return accountHolder.getId() == id;
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
        if (checkId(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkId(userID)){
            this.balance -= (amount + ATM_FEE);
        }
    }
}
