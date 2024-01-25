import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;
    private double currentBalance;

    Withdraw(double amount, Date date, String account, double currentBalance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.currentBalance = currentBalance;
    }
    //Getters and Setters...
    public int getamount() {
        return amount;
    }
    public void setamount(int amount) {
        this.amount = amount;
    }
     public String getaccount() {
        return account;
    }
    public void setaccount(String account) {
        this.account = account;
    }
     public double getcurrentBalance() {
        return currentBalance;
    }
    public void setcurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString(){
        return "Withdrawal of $" + amount + " on " + date + " into account: " + account +
        "; Current balance in " + account + " is: $" + currentBalance;
    }
}
