
/**
 * Models a sentence pair with an indicator if its correctly answered or not. 
 * 
 * @author Angela Zhou 
 * @version 1.0
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
     * Constructs a sentence pair with default characteristics. 
     */
    public SentencePair(String english, String french)
    {
        this.english = english;
        this.french = french;
        this.correctlyAnswered = false;
    } 
    
    /**
     * Gets the Englsih. 
     */
    public String getEnglish()
    {
        return english;
    }
    
    /**
     * Gets the French. 
     */
    public String getFrench()
    {
        return french;
    }
    
     /**
     * Whether it is correctly answered. 
     */
    public boolean isCorrectlyAnswered()
    {
        return correctlyAnswered;
    }
    
    /**
     * Sets correctly answered or not. 
     */
    public void setCorrectlyAnswered(boolean correct)
    {
        this.correctlyAnswered = correct;
    }
}
