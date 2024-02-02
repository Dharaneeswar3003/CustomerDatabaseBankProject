import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    
    @Test
    public void testDeposit() {
        System.out.println("Check balence");
       Customer customer = new Customer("John Doe", 123456, 1000.0, 2000.0);
        Date today = new Date();
        double newCheckBalance = customer.deposit(500, today, Customer.CHECKING);
        assertEquals(1500.0, newCheckBalance, 0.01); 
        double newSaveBalance = customer.deposit(300, today, Customer.SAVING);
        assertEquals(2300.0, newSaveBalance, 0.01);
        double invalidDepositResult = customer.deposit(200.0, today, "InvalidAccountType");
        assertEquals(-1, invalidDepositResult, 0.01);
    }
     @Test
    public void testWithdraw() {
        Customer customer = new Customer("John Doe", 123456, 1000.0, 2000.0);
        Date today = new Date();
        double newCheckBalance = customer.withdraw(500, today, Customer.CHECKING);
        assertEquals(500.0, newCheckBalance, 0.01);
       double newSaveBalance = customer.withdraw(400, today, Customer.SAVING);
        assertEquals(1600.0, newSaveBalance, 0.01);
        double invalidWithdrawResult = customer.withdraw(200.0, today, "InvalidAccountType");
        assertEquals(-1, invalidWithdrawResult, 0.01);
        // Test overdraft scenario for checking account
        double overdraftResultChecking = customer.withdraw(1200.0, today, Customer.CHECKING);
        assertEquals(-1, overdraftResultChecking, 0.01);

        // Test overdraft scenario for savings account
        double overdraftResultSaving = customer.withdraw(2500.0, today, Customer.SAVING);
        assertEquals(-1, overdraftResultSaving, 0.01);
    }
    @Test
    public void testDisplayDepositsandWithdrawals() {
        Customer customer = new Customer("John Doe", 123456, 1000.0, 2000.0);
        Date today = new Date();
        // Test display deposits when no deposits are made
        customer.displayDeposits();
        // Test display withdrawals when no withdrawals are made
        customer.displayWithdraws();
        customer.deposit(500.0, today, Customer.CHECKING);
        customer.displayDeposits();
        customer.withdraw(200.0, today, Customer.SAVING);
        customer.displayWithdraws();
        
    }
    @Test
    public void testMultipleDepositsAndWithdrawals() {
    Customer customer = new Customer("John Doe", 123456, 1000.0, 2000.0);
    Date today = new Date();

    // Multiple deposits to both checking and savings accounts
    customer.deposit(500.0, today, Customer.CHECKING);
    customer.deposit(300.0, today, Customer.SAVING);
    customer.deposit(200.0, today, Customer.CHECKING);
    customer.deposit(100.0, today, Customer.SAVING);

    // Multiple withdrawals from both checking and savings accounts
    customer.withdraw(150.0, today, Customer.CHECKING);
    customer.withdraw(50.0, today, Customer.SAVING);
    customer.withdraw(300.0, today, Customer.CHECKING);
    customer.withdraw(100.0, today, Customer.SAVING);

    // Check final balances
    assertEquals(1250.0, customer.getcheckBalance(), 0.01);
    assertEquals(2250.0, customer.getsavingBalance(), 0.01);
    }
}
