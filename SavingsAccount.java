
/**
 * A savings account earns a fixed rate of interest.
 * 
 * @author Angela Zhou
 * @version 1
 */
public class SavingsAccount extends BankAccount
{
    // instance fields
    private double rate;

    // constructors
    
    /**
     *  Constructs a savings account with a zero 
     *  balance and the specified percentage annual interest rate.
     */
    public SavingsAccount(double rate) 
    {
        if (rate >= 0)
        {
            this.rate = rate;
        } // end of if (rate >= 0)
        setBalance(0);
    } // end of constructor public SavingsAccount(double rate) 
    
    /**
     * Constructs a bacnk account with the specified balance.
     */
    public SavingsAccount(double initialBalance, double rate) 
    {
        if (rate >= 0)
        {
            this.rate = rate;
        }
        setBalance(initialBalance);
    } // end of constructor public SavingsAccount(double initialBalance, double rate) 
   
    // methods
    
    /**
     * Adds the earned interest to balance of this account.
     */
    public void addInterest()
    {
        balance = balance + (balance * rate);
    } // end of method public void addInterest()
    
    /**
     * Returns this account’s annual interest rate. 
     * 
     * @return this account’s interest rate
     */
    public double getRate()
    {
        return rate;
    } // end of method public double getRate()
    
    /**
     * Sets the annual interest rate of this account.
     * 
     * @param rate - the new interest rate
     * <br><i>precondition:</i> rate must be non-negative
     */
    public void setRate(double rate)
    {
        if (rate >= 0)
        {
            this.rate = rate;
        }
    } // end of method   public void setRate(double rate)
    
    /**
     * Returns a string representation of this account.
     *
     * @override toString in class BankAccount
     * @return a string representing this bank account
     */
    public String toString()
    {
        return getClass().getName()
        + " ["
        + "balance: " + balance
        + ", account number: " + accountNumber
        + ", rate: " + rate
        + "]";
    } // end of method public String toString()
} // end of class BankAccount