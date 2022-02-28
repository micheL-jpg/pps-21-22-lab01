import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {

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
}
