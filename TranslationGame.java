
/**
 * An English/French translation game.
 * 
 * @author Angela Zhou 
 * @version 1
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Random;

public class TranslationGame
{
    private static BufferedReader console = 
        new BufferedReader(new InputStreamReader(System.in));
    private static Random random = new Random();
    
    private static final String ENGLISH_FILE = "english.txt";
    private static final String FRENCH_FILE = "french.txt";
    private static final String OUTPUT_FILE = "outputFile.txt";

    private static final String SENTINEL_VALUE = "q";

    private static HashMap<Integer, SentencePair> sentencePairs;

    /** 
     * The main method. 
     * 
     * @param argument not used
     */
    public static void main(String[] argument) throws IOException
    {
        displayPreviousResultsIfThereIs();
        
        sentencePairs = preparePairs();
        int goal = takeUserGoal();
        
        int sentenceCount = 0; 
        boolean inputEqualsSentinelValue = false;
        
        System.out.println("Please translate to the other langauge. (q=quit)");
        while (sentenceCount < goal && !inputEqualsSentinelValue)
        {
            SentencePair pair = takeNextUnansweredPair();
            int chosenLanguage = generateRandom(2);
            String presentedPhrase = null;
            String expectedTranslation = null; 
            if (chosenLanguage == 0)
            {
                presentedPhrase = pair.getEnglish();
                expectedTranslation = pair.getFrench(); 
            }
            else
            {
                presentedPhrase = pair.getFrench();
                expectedTranslation = pair.getEnglish(); 
            }

            System.out.print("\n" + presentedPhrase + " ");
            String input = console.readLine();
            if ("q".equalsIgnoreCase(input))
            {
                inputEqualsSentinelValue = true;
            }
            else 
            {
                if (input.equals(expectedTranslation))
                {
                    sentenceCount++;
                    pair.setCorrectlyAnswered(true);
                    System.out.println("\nCorrect!");
                } 
                else
                {
                    System.out.println("\nSorry, incorrect!");
                } // end of if (input.equals(expectedTranslation))
            } // end of if ("q".equalsIgnoreCase(input))
        } // end of while (sentenceCount < goal && !inputEqualsSentinelValue)
        System.out.println("\nNumber correctly translated phrases: " + sentenceCount + "/10"); 
        
        new ResultWriter(OUTPUT_FILE).write(sentenceCount);
    } // end of public static void main(String[] arguement) throws IOException

    private static HashMap<Integer, SentencePair> preparePairs() throws IOException
    {
        return new SentencePairReader(ENGLISH_FILE, FRENCH_FILE).read();
    } // end of private static HashMap<Integer, SentencePair> preparePairs() throws IOException

    private static int takeUserGoal() throws IOException
    {
        int input = 0;
        final int UPPER_LIMIT = sentencePairs.size();

        boolean inputValid = false;        
        do
        {
            System.out.print("goal: ");
            try
            {
                input = Integer.parseInt(console.readLine()); 

                if (input <= UPPER_LIMIT && input > 0)
                {
                    inputValid = true;
                }
                else
                {
                    System.out.println("Goal not in range." 
                        + " Please re-enter a number between 1 - " + UPPER_LIMIT + ".");
                }
            }
            catch (NumberFormatException exception)
            {
                System.out.println("Numbers only. Please re-enter.");
            } // end of catch (NumberFormatException exception)
            System.out.println();
        }
        while (!inputValid);

        return input;
    } // end of  private static int takeUserGoal() throws IOException

    private static int generateRandom (int upperLimit)
    {
        return random.nextInt(upperLimit); 
    } // end of private static int generateRandom (int upperLimit)

    private static SentencePair takeNextUnansweredPair()
    {
        SentencePair result = null; 
        do 
        {
            int chosenKey = generateRandom(sentencePairs.size());
            result = sentencePairs.get(chosenKey);
        }
        while (result.isCorrectlyAnswered());
        return result;
    } // end of private static SentencePair takeNextUnansweredPair()
    
    private static void displayPreviousResultsIfThereIs() throws IOException
    {
        ResultReader resultReader = new ResultReader(OUTPUT_FILE);
        
        try 
        {
            resultReader.read();
            System.out.println("*** Scores ***");
            System.out.println("lowest score: " + resultReader.getLowestScore());
            System.out.println("highest score: " + resultReader.getHighestScore());
            System.out.println("last score: " + resultReader.getLatestScore());
            System.out.println();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("No previous results.");
        } // end of catch (FileNotFoundException exception)
    } // end of private static void displayPreviousResultsIfThereIs() throws IOException

} // end of public class TranslationGame
