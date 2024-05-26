import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Customer customer;
    private final double initialCheckingBalance = 1000.0;
    private final double initialSavingBalance = 2000.0;

    @Before
    public void setUp() {
        customer = new Customer("John Doe", 123456, initialCheckingBalance, initialSavingBalance);
    }

    @Test
    public void testInitialBalances() {
        assertEquals(initialCheckingBalance, customer.getcheckBalance(), 0.001);
        assertEquals(initialSavingBalance, customer.getsavingBalance(), 0.001);
    }

    @Test
    public void testDepositChecking() {
        double depositAmount = 500.0;
        Date date = new Date();
        customer.deposit(depositAmount, date, Customer.CHECKING);

        assertEquals(initialCheckingBalance + depositAmount, customer.getcheckBalance(), 0.001);
    }

    @Test
    public void testDepositSaving() {
        double depositAmount = 300.0;
        Date date = new Date();
        customer.deposit(depositAmount, date, Customer.SAVING);

        assertEquals(initialSavingBalance + depositAmount, customer.getsavingBalance(), 0.001);
    }

    @Test
    public void testWithdrawChecking() {
        double withdrawAmount = 200.0;
        Date date = new Date();
        customer.withdraw(withdrawAmount, date, Customer.CHECKING);

        assertEquals(initialCheckingBalance - withdrawAmount, customer.getcheckBalance(), 0.001);
    }

    @Test
    public void testWithdrawSaving() {
        double withdrawAmount = 400.0;
        Date date = new Date();
        customer.withdraw(withdrawAmount, date, Customer.SAVING);

        assertEquals(initialSavingBalance - withdrawAmount, customer.getsavingBalance(), 0.001);
    }

    @Test
    public void testOverdraftChecking() {
        double withdrawAmount = 1100.0; // More than the checking balance
        Date date = new Date();
        double result = customer.withdraw(withdrawAmount, date, Customer.CHECKING);

        // Ensure the withdrawal was not allowed
        assertEquals(-1, result, 0.001);
        assertEquals(initialCheckingBalance, customer.getcheckBalance(), 0.001);
    }

    @Test
    public void testOverdraftSaving() {
        double withdrawAmount = 2100.0; // More than the saving balance
        Date date = new Date();
        double result = customer.withdraw(withdrawAmount, date, Customer.SAVING);

        // Ensure the withdrawal was not allowed
        assertEquals(-1, result, 0.001);
        assertEquals(initialSavingBalance, customer.getsavingBalance(), 0.001);
    }
}
