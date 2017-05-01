
/**
 * Reads sentence pairs from a text file.
 * 
 * @Angela Zhou
 * @version 1
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

public class SentencePairReader
{
    private String englishFile;
    private String frenchFile;
    
    /** 
     * Constructs file names with default characteristics. 
     * 
     * @param englishFileName the english file
     * @param frenchFileName the frenchFile
     */
    public SentencePairReader(String englishFileName, String frenchFileName)
    {
        this.englishFile = englishFileName;
        this.frenchFile = frenchFileName;
    } // end of public SentencePairReader(String englishFileName, String frenchFileName)
    
   /** 
     * Reads sentence pairs, then loads pairs into a hashmap. 
     */
    public HashMap<Integer, SentencePair> read() throws IOException
    { 
        HashMap<Integer, SentencePair> result = new HashMap<Integer, SentencePair>();
        
        BufferedReader englishFileReader = new BufferedReader(new FileReader(englishFile));
        BufferedReader frenchFileReader = new BufferedReader(new FileReader(frenchFile));
        
        String englishLine = englishFileReader.readLine();
        String frenchLine = frenchFileReader.readLine();
        int key = 0;   
        while (englishLine != null && frenchLine != null)
        {
            result.put(key, new SentencePair(englishLine, frenchLine));
            key++;
            englishLine = englishFileReader.readLine();
            frenchLine = frenchFileReader.readLine();
        } // end of  while (englishLine != null && frenchLine != null)
        
        englishFileReader.close();
        frenchFileReader.close();
        
        return result; 
    } // end of public HashMap<Integer, SentencePair> read() throws IOException
} // end of public class SentencePairReader
