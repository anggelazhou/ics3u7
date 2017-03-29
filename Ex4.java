
/**
 * Array excercise 4: Gather marks and then display them with the highest and 
 * lowest identified in some way. (Note: Do not display the highest and lowest 
 * after the display of all marks.)
 * 
 * @author Angela Zhou 
 * @version 2017-03-29
 */

// import necessary classes
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ex4
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
        // System.out.print("\nmark? ");

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
            System.out.println("\nNo marks entered, so there is no min or max mark.");
        } // end of if
        else
        {
            double minMark = MAX_MARK;
            double maxMark = 0;
            // Display marks
            for (int i = 0; i < markIndex; i++)
            {
                if (mark[i] > maxMark) 
                {
                    maxMark = mark[i];
                }
                if (mark[i] < minMark) 
                {
                    minMark = mark[i];
                } // end of if
            } // end of for
            for (int i = 0; i < markIndex; i++)
            {    
                if (mark[i] != maxMark && mark[i] != minMark)
                {
                    System.out.println(i + 1 + ": " + mark[i]);
                }
                if (mark[i] == maxMark)
                {
                    System.out.println(i + 1 + "(highest): " + mark[i]);
                }
                if (mark[i] == minMark)
                {
                    System.out.println(i + 1 + "(lowest): " + mark[i]);
                }
            } // end of for
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
} // end of public class Ex4
