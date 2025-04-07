package TP0.exoBonus1;


import TP0.exoBonus1.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConstructorValid() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        assertEquals(100.0, account.getBalance(), 0.0001);
        assertEquals(0.05, account.getInterestRate(), 0.0001);
    }

    @Test
    void testConstructorNegativeBalance() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-10.0, 0.05);
        });
        assertEquals("Initial balance must be positive", exception.getMessage());
    }

    @Test
    void testConstructorNegativeInterestRate() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(100.0, -0.05);
        });
        assertEquals("Interest rate must be positive", exception.getMessage());
    }

    // ----------------------------
    // Tests de la méthode deposit
    // ----------------------------
    @Test
    void testDepositValid() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositNegative() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void testDepositBoundaryOverflow() {
        // Cas limite : dépôt qui porte le solde à Double.MAX_VALUE
        final BankAccount account = new BankAccount(100.0, 0.05);
        final double amount = Double.MAX_VALUE - 100.0;
        account.deposit(amount);
        assertEquals(Double.MAX_VALUE, account.getBalance(), 0.0001);

        // Test pour un dépassement
        final BankAccount accountOverflow = new BankAccount(100.0, 0.05);
        final double tooMuch = Double.MAX_VALUE - 100.0 + 1;
        final Exception exception = assertThrows(ArithmeticException.class, () -> {
            accountOverflow.deposit(tooMuch);
        });
        assertEquals("Deposit would cause balance overflow", exception.getMessage());
    }

    // ----------------------------
    // Tests de la méthode withdraw
    // ----------------------------
    @Test
    void testWithdrawValid() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawNegative() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20.0);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        final BankAccount account = new BankAccount(100.0, 0.05);
        final Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(150.0);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    // ----------------------------
    // Tests de la méthode transfer
    // ----------------------------
    @Test
    void testTransferValid() {
        final BankAccount source = new BankAccount(100.0, 0.05);
        final BankAccount target = new BankAccount(50.0, 0.03);
        source.transfer(60.0, target);
        assertEquals(40.0, source.getBalance(), 0.0001);
        assertEquals(110.0, target.getBalance(), 0.0001);
    }

    @Test
    void testTransferNullAccount() {
        final BankAccount source = new BankAccount(100.0, 0.05);
        final Exception exception = assertThrows(NullPointerException.class, () -> {
            source.transfer(20.0, null);
        });
        assertEquals("Other account must not be null", exception.getMessage());
    }

    @Test
    void testTransferRollbackOnDepositFailure() {
        final BankAccount source = new BankAccount(100.0, 0.05);
        // Pour simuler une erreur lors du dépôt, on crée un compte défectueux
        final BankAccount faultyTarget = new BankAccount(50.0, 0.03) {
            @Override
            public void deposit(double amount) {
                throw new RuntimeException("Simulated deposit failure");
            }
        };

        final Exception exception = assertThrows(RuntimeException.class, () -> {
            source.transfer(30.0, faultyTarget);
        });
        // Vérification que le retrait a été annulé (rollback)
        assertEquals(100.0, source.getBalance(), 0.0001);
        assertEquals("Simulated deposit failure", exception.getMessage());
    }

    // ----------------------------
    // Tests de la méthode addInterest
    // ----------------------------
    @Test
    void testAddInterestValid() {
        final BankAccount account = new BankAccount(200.0, 0.10); // 10% d'intérêt
        account.addInterest();
        assertEquals(220.0, account.getBalance(), 0.0001);
    }

    @Test
    void testAddInterestWithZeroBalance() {
        // Vérifie que l'ajout d'intérêt sur un solde nul ne change rien
        final BankAccount account = new BankAccount(0.0, 0.10);
        account.addInterest();
        assertEquals(0.0, account.getBalance(), 0.0001);
    }

    @Test
    void testAddInterestOverflow() {
        // Pour provoquer un dépassement, créer un compte avec un solde très élevé et un taux d'intérêt important
        final BankAccount account = new BankAccount(Double.MAX_VALUE / 2, 1.1); // 110% d'intérêt
        final Exception exception = assertThrows(ArithmeticException.class, () -> {
            account.addInterest();
        });
        assertEquals("Interest calculation would cause overflow", exception.getMessage());
    }
}
