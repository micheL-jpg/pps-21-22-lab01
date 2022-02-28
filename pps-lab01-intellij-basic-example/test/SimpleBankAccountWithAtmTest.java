import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {

    public static final int ATM_FEE = 1;
    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccountWithAtm;

    @BeforeEach
    void setUp() {
        accountHolder = new AccountHolder("Michele", "Bachetti", 1);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder);
    }

    @Test
    void testInitialBankAccount() {
        assertEquals(accountHolder.toString(), bankAccountWithAtm.getHolder().toString());
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 100);
        bankAccountWithAtm.withdraw(accountHolder.getId(), 30);
        assertEquals(100-30- ATM_FEE, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositWithWrongAccount() {
        bankAccountWithAtm.deposit(2, 100);
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithWrongAccount() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 100);
        bankAccountWithAtm.withdraw(2, 30);
        assertEquals(100, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWithInsufficientBalance() {
        bankAccountWithAtm.deposit(accountHolder.getId(), 30);
        bankAccountWithAtm.withdraw(accountHolder.getId(), 30);
        assertEquals(30, bankAccountWithAtm.getBalance());
    }
}
