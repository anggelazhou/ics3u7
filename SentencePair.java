
/**
 * Models a sentence pair with an indicator if its correctly answered or not. 
 * 
 * @author Angela Zhou 
 * @version 1
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class SentencePair
{
    private String english;
    private String french;
    private boolean correctlyAnswered;
     
    /**
     * Constructs a sentence with default characteristics. 
     * 
     * @param english english phrase
     * @param french french phrase
     */
    public SentencePair(String english, String french)
    {
        this.english = english;
        this.french = french;
        this.correctlyAnswered = false;
    } // end of public SentencePair(String english, String french)
    
    /**
     * Gets the Englsih phrase. 
     */
    public String getEnglish()
    {
        return english;
    } // end of public String getEnglish()
    
    /**
     * Gets the French phrase. 
     */
    public String getFrench()
    {
        return french;
    } // end of public String getFrench()
    
     /**
     * Whether it is correctly answered. 
     */
    public boolean isCorrectlyAnswered()
    {
        return correctlyAnswered;
    } // end of public boolean isCorrectlyAnswered()
    
    /**
     * Sets correctly answered or not. 
     * 
     * @param correct correct or not
     */
    public void setCorrectlyAnswered(boolean correct)
    {
        this.correctlyAnswered = correct;
    } // end of public void setCorrectlyAnswered(boolean correct)
} // end of public class SentencePair
