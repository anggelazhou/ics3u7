
/**
 * An English/French translation game.
 * 
 * @author Angela Zhou 
 * @version 1
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class TranslationGame
{
    private static BufferedReader console = 
        new BufferedReader(new InputStreamReader(System.in));
    private static Random random = new Random();

    private static final String SENTINEL_VALUE = "q";

    private static HashMap<Integer, SentencePair> sentencePairs;

    public static void main(String[] arguement) throws IOException
    {
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
                }
            }
        } // end of while (sentenceCount < goal && !inputEqualsSentinelValue)
        System.out.println("\nNumber correctly translated phrases: " + sentenceCount); 
    }

    private static HashMap<Integer, SentencePair> preparePairs()
    {
        HashMap<Integer, SentencePair> result = new HashMap<Integer, SentencePair>();

        result.put(0, new SentencePair("What's your name?",
                "Comment vous appelez-vous?"));
        result.put(1, new SentencePair("Pleased to meet you!",
                "Enchanté(e)!"));
        result.put(2, new SentencePair("I'm from the U.S.A..",
                "Je viens des États-Unis."));
        result.put(3, new SentencePair("I live in Canada.",
                "J'habite au Canada."));
        result.put(4, new SentencePair("What is your profession?",
                "Qu'est-ce que vous faites?"));
        result.put(5, new SentencePair("What do you do in your free time?",
                "Qu'est-ce que vous aimez faire pendant votre temps libre?"));
        result.put(6, new SentencePair("How's the weather?",
                "Quel temps fait-il?"));
        result.put(7, new SentencePair("Do you have siblings?",
                "Est-ce que vous avez des frères et sœurs?"));
        result.put(8, new SentencePair("What's your favorite movie?",
                "Quel est ton/votre film préféré?"));
        result.put(9, new SentencePair("Have you visited Paris?",
                "Est-ce que vous avez visité le Paris? "));

        return result;
    }

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
            }
            System.out.println();
        }
        while (!inputValid);

        return input;
    }

    private static int generateRandom (int upperLimit)
    {
        return random.nextInt(upperLimit); 
    }

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
    }

}
