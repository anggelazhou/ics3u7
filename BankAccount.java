
/**
 * An account with a unique serial number
 * 
 * @author Angela Zhou
 * @version 1
 */
public class BankAccount
{
    // class fields
    private static int nextAccountNumber = 1; 
    
    // instance fields
    private double balance;
    private int accountNumber;

    // constructors
    
    /**
     * Constructs an account with a zero balance
     */
    public BankAccount()
    {
        balance = 0;
        accountNumber = nextAccountNumber++;
    } // end of constructor public BankAccount()
    
    /**
     * Constructs a bacnk account with the specified balance.
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
        accountNumber = nextAccountNumber++; 
    } // end of constructor public BankAccount(double initialBalance)
   
    // methods
    
    /**
     * Deposits money into this account. 
     * 
     * @param  amount - the amount to be deposited 
     * <br><i>precondition:</i> amount must be non-negative
     */
    public void deposit(double amount)
    {
        if (amount >= 0)
        {
            balance = balance + amount;
        } // end of if (amount >= 0)
    } // end of method public void deposit(double amount)
    
    /**
     * Returns the unique serial number of this account. 
     * 
     * @return the serial number
     */
    public int get_ID_number()
    {
        return accountNumber;
    } // end of method public int get_ID_number()
    
    /**
     * Returns the current balance of this account.
     * 
     * @return the current balance
     */
    public double getBalance()
    {
        return balance; 
    } // end of method  public double getBalance()
    
    /**
     * Sets the balance of this account.
     * <br><i>precondition:</i> must be non-negative
     * 
     * @param balance the new non-negative balance
     */
    public void setBalance(double newBalance)
    {
        if (newBalance >= 0) 
        {
            balance = newBalance;
        } // end of if (newBalance >= 0) 
    } // end of method  public double getBalance(double newBalance)
    
    /**
     * Returns a string representation of this account.
     *
     * @override toString in class Object
     * @return a string representing this bank account
     */
    public String toString()
    {
        return getClass().getName()
        + " ["
        + "balance: " + balance
        + ", account number: " + accountNumber
        + "]";
    } // end of method public String toString()
    
    /**
     * Withdraws money from this account.
     * 
     * @amount - the non-negative amount to be withdrawn
     * <br><i>precondition:</i> amount must be ≤ this account’s balance
     */
    public void withdraw(double amount)
    {
        if (amount >= 0 && amount <= balance)
        {
            balance = balance - amount;
        } // end of if (amount >= 0)
    } // end of method public void withdraw(double amount)
} // end of class BankAccount
