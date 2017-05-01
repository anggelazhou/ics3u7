
/**
 * Read sentence pairs from a text file.
 * 
 * @author Angela Zhou
 * @version 1
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResultReader
{
    private String resultFileName;
    
    private int lowestScore = Integer.MAX_VALUE;
    private int highestScore = Integer.MIN_VALUE;
    private int latestScore;
    
    /**
     * Constructs a result reader with default characteristics.
     * 
     * @param resultFileName result file name
     */
    public ResultReader(String resultFileName)
    {
        this.resultFileName = resultFileName;
    } // end of public ResultReader(String resultFileName)
    
    /**
     * Finds highest, lowest and latest result from result file.
     */
    public void read() throws IOException
    { 
        BufferedReader resultFileReader = new BufferedReader(new FileReader(resultFileName));
    
        String resultLine = resultFileReader.readLine();
        while (resultLine != null)
        {
            int score = Integer.parseInt(resultLine);
            
            if (score < lowestScore)
            {
                lowestScore = score;
            }
            if (score > highestScore)
            {
                highestScore = score;
            }
            latestScore = score;
            
            resultLine = resultFileReader.readLine();
        } // end of  while (englishLine != null && frenchLine != null)
        
        resultFileReader.close();
    } // end of public void read() throws IOException
    
    /**
     * Gets lowest score.
     */
    public int getLowestScore()
    {
        return lowestScore;
    } // end of public int getLowestScore()
    
     /**
     * Gets highest score.
     */
    public int getHighestScore()
    {
        return highestScore;
    } // end of public int getHighestScore()
    
     /**
     * Gets latest score.
     */
    public int getLatestScore()
    {
        return latestScore;
    } // end of public int getLatestScore()
}
