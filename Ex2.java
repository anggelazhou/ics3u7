
/**
 * Array excercise 2: gather marks and then display them and their mean, reject 
 * marks which are out of range.
 * 
 * @author Angela Zhou 
 * @version 2017-03-27
 */

// import necessary classes
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ex2
{
    // constants
    private static final int MAX_MARK = 100;
    private static final int ARRAY_MAX_LENGTH = 100;

    // instance variables
    private static int markIndex;

    private static BufferedReader console = 
        new BufferedReader(new InputStreamReader(System.in));
    private static double[] mark = new double[ARRAY_MAX_LENGTH];

    public static void main(String[] argument) throws IOException
    {
        System.out.println("Welcome!");

        // Gather input from the user.

        while (true) 
        {

            System.out.print("\nEnter mark (q=quit): ");

            try
            {
                String input = console.readLine();

                if ("q".equalsIgnoreCase(input))
                {
                    System.out.print("\nAre you sure you want to quit (y/n): ");
                    String confirm = console.readLine();
                    if ("y".equalsIgnoreCase(confirm))
                    {
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }   
                else 
                {

                    mark[markIndex] = Double.parseDouble(input);

                    if (isInRange(markIndex))
                    {
                        markIndex++;
                    }
                    else
                    {
                        System.out.println("Input out of range, so rejected. "
						    + "Please RE-ENTER a mark between 0 - " + MAX_MARK);
                    }
                }
            } // end of try

            catch (NumberFormatException exception)
            {
                System.out.println("Object catch: " + exception);
                System.out.println("Numbers only. Please RE-ENTER.");
            } // end of catch (NumberFormatException exception)

        } // end of while           

        System.out.println();

        // Display mean of marks
        if (markIndex == 0)
        {
            System.out.println("\nNo marks entered.");
            System.out.println("\nmean: 0");
        } // end of if
        else
        {
            double markSum = 0d;

            // Display marks
            for (int i = 0; i < markIndex; i++)
            {
                System.out.println((i + 1) + ": " + mark[i]); 
                markSum = markSum + mark[i];
            }
            System.out.println("\nMean: " + (markSum / markIndex));
        } // end of else

    } // end of main(String[] argument)

    /**
     * Method to check if input of mark at this input position is valid 
	 * (between 0 - max valid mark). 
     * 
     * @param int markPosition mark index
     */
    private static boolean isInRange(int markPosition)
    {
        return mark[markPosition] >= 0 && mark[markPosition] <= MAX_MARK;
    }
} // end of public class Ex2
