
/**
 * A time deposit account earns a fixed rate of interest for a fixed period
 * of time called the term of the deposit. If withdrawals are made before the term 
 * expiration, the interest rate is halved.
 * 
 * @author Angela
 * @version 1
 */
public class TimeDepositAccount extends SavingsAccount
{
    // static fields
    public static final String MINIMUM_DATE = "2000-01-01";
   
    // instance fields
    private String termExpiration;

    // constructors
    
    /**
     *  Constructs a bank account with the specifed initial balance, the specifed percentage 
     *  interest rate (for example, a rate of 10.5% is specified as 10.5), and a date until 
     *  which the rate applies.
     *  
     *  initialBalance - the initial balance <br><i>precondition:</i> must be non-negative
     *  @param rate - the interest rate <br><i>precondition:</i> must be non-negative
     *  @param termExpiration - the date in ISO 8601 format (yyyy-mm-dd) on which the term expires
     *  <br><i>precondition:</i> may not be earlier than MINIMUM_DATE
     *  @param
     */
    public TimeDepositAccount(double initialBalance, double rate, String termExpiration) 
    {
        super(initialBalance, rate);
        try
        {
            String[] stringDate = termExpiration.split("-");
            String[] strinMinDate = MINIMUM_DATE.split("-");
            for (int i = 1; i < stringDate.length; i++)
            {
                int[] date = new int[3];
                int[] minDate = new int[3];

                date[i] = Integer.parseInt(date[i]); 
                minDate[i] = Integer.parseInt(minDate[i]); 
            } // end of for (int i = 0; i < date.length; i++)
            
            int inputYear = date[0];
            int minYear = minDate[0];
            
            if (date[1] >= 1 && date[1] <= 12)
            {
                 int inputMonth = date[1];
            } // end of if (date[1] >= 1 && date[1] <= 12)
            int minMonth = minDate[1];
            
            if (date[2] >= 1 && date[2] <= 31)
            {
                 int inputDay = date[2];
            } // end of if (date[2] >= 1 && date[2] <= 31)
            int minDay = minDate[2];
            
            if (inputYear > minYear)
            {
                this.termExpiration = termExpiration;
            } 
            else if (inputYear = minYear)
            {
                if (inputMonth > minMonth)
                {
                    this.termExpiration = termExpiration;
                }
                else if (inputMonth = minMonth)
                {
                    if (inputDay > minDay)
                    {
                        this.termExpiration = termExpiration;
                    } // end of if (inputDay > minDay)
                } // end of if (inputMonth > minMonth)
            } // end of if (inputYear = minYear)
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Please enter a valid date.");
        }
    } // end of constructor public TimeDepositAccount(double initialBalance... 
    
    /**
     * Constructs a bank account with a zero balance, the specifed percentage interest rate 
     * (for example, a rate of 10.5% is specified as 10.5), and a date until which the rate 
     * applies.
     * 
     *  @param rate - the interest rate <br><i>precondition:</i> must be non-negative
     *  @param termExpiration - the date in ISO 8601 format (yyyy-mm-dd) on which the term expires
     *  <br><i>precondition:</i> may not be earlier than MINIMUM_DATE
     */
    TimeDepositAccount(double rate, String termExpiration) 
    {
        super(rate); 
        this.termExpiration = termExpiration; 
    } // end of constructor TimeDepositAccount(double rate, String termExpiration) 
   
    // methods
    
    /**
     * Returns the date on which this account’s term expires.
     *
     * @return this account’s term-expiration date
     */
   public String getTermExpiration()
    {
       return termExpiration; 
    } // end of method public String getTermExpiration()
    
    /**
     * Sets the term of this account. 
     * 
     * @param termExpiration - the date in ISO 8601 format (yyyy-mm-dd) on which the term expires
     * <br><i>precondition:</i> may not be earlier than MINIMUM_DATE
     */
    public void setTerm(String termExpiration)
    {
        return rate;
    } // end of method public void setTerm(String termExpiration)
    
    /**
     * Returns a string representation of this time-deposit account.
     *
     * @override toString in class SavingsAccount
     * @return a string representing this time-deposit account.
     */
    public String toString()
    {
        return getClass().getName()
        + " ["
        + ", term expiration: " + termExpiration
        + "]";
    } // end of method public String toString()
}
