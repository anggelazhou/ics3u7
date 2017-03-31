
/**
 * Array excercise 5: For a class of fixed size, gather marks for two different 
 * assignments and then display the mean of each assignment.
 * 
 * @author Angela Zhou 
 * @version 2017-03-29
 */

// import necessary classes
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ex5
{
    // constants
    private static final int MAX_MARK = 100;
    private static final int ARRAY_MAX_LENGTH = 100;
    private static final int MAX_CLASS_SIZE = 100;

    // instance variables
    private static int markIndex;
    private static int classSize;

    private static BufferedReader console = 
        new BufferedReader(new InputStreamReader(System.in));
    private static double[] mark1 = new double[ARRAY_MAX_LENGTH];
    private static double[] mark2 = new double[ARRAY_MAX_LENGTH];

    public static void main(String[] argument) throws IOException
    {
        System.out.println("Welcome!");

        // Gather input from the user.
        // System.out.print("\nmark? ");

        while (true) 
        {

            System.out.print("\nEnter class size: ");

            try
            {
                classSize = Integer.parseInt(console.readLine());

                if (classSize < 0 || classSize > MAX_CLASS_SIZE)
                {
                    System.out.println("Input out of range, so rejected. "
                        + "Please RE-ENTER a class size between 0 - " 
                        + MAX_CLASS_SIZE);
                }   
                else 
                {
                    break;
                }
            } // end of try

            catch (NumberFormatException exception)
            {
                System.out.println("Object catch: " + exception);
                System.out.println("Numbers only. Please RE-ENTER.");
            } // end of catch (NumberFormatException exception)

        } // end of while        

        System.out.println("Enter marks below: ")
        for (markIndex = 0; markIndex < classSize; markIndex++)
        {
            try
            {
                System.out.println("Student " + (markIndex + 1)
                    + ": ");
                    
                System.out.print("Mark 1: ");
                mark1[markIndex] = Double.parseDouble(console.readLine());
                if (!mark1IsInRange(markIndex))
                {
                    System.out.println("Input out of range, so rejected. "
                        + "Please RE-ENTER a mark between 0 - " + MAX_MARK);
                }
     
                System.out.print("Mark 2: ");
                mark2[markIndex] = Double.parseDouble(console.readLine());
                 if (!mark2IsInRange(markIndex))
                {
                    System.out.println("Input out of range, so rejected. "
                        + "Please RE-ENTER a mark between 0 - " + MAX_MARK);
                }
            }
            catch (NumberFormatException exception)
            {
                System.out.println("Object catch: " + exception);
                System.out.println("Numbers only. Please RE-ENTER.");
            } // end of catch (NumberFormatException exception)
        }

        //         // Display mean of marks
        //         if (markIndex == 0)
        //         {
        //             System.out.println("\nNo marks entered.");
        //         } // end of if
        //         else
        //         {
        //             double minMark = MAX_MARK;
        //             double maxMark = 0;
        //             // Display marks
        //             for (int i = 0; i < markIndex; i++)
        //             {
        //                 if (mark[i] > maxMark) 
        //                 {
        //                     maxMark = mark[i];
        //                 }
        //                 if (mark[i] < minMark) 
        //                 {
        //                     minMark = mark[i];
        //                 } // end of if
        //             } // end of for
        //             for (int i = 0; i < markIndex; i++)
        //             {    
        //                 if (mark[i] != maxMark && mark[i] != minMark)
        //                 {
        //                     System.out.println(i + 1 + ": " + mark[i]);
        //                 }
        //                 if (mark[i] == maxMark)
        //                 {
        //                     System.out.println(i + 1 + "(highest): " + mark[i]);
        //                 }
        //                 if (mark[i] == minMark)
        //                 {
        //                     System.out.println(i + 1 + "(lowest): " + mark[i]);
        //                 }
        //             } // end of for
        //         } // end of else

    } // end of main(String[] argument)

    /**
     * Method to check if input of mark at this input position is valid 
     * (between 0 - max valid mark). 
     * 
     * @param int markPosition mark index
     */
    private static boolean mark1IsInRange(int markPosition)
    {
        return mark1[markPosition] >= 0 && mark1[markPosition] <= MAX_MARK;
    }
    
    private static boolean mark2IsInRange(int markPosition)
    {
        return mark2[markPosition] >= 0 && mark2[markPosition] <= MAX_MARK;
    }
} // end of public class Exercises5