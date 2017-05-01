
/**
 * Records player result into a text file.
 * 
 * @author Angela Zhou
 * @version 1
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultWriter
{
   private String outputFileName;
   
   /**
     * Constructs a result writer with default characteristics.
     * 
     * @param outFileName output file name
     */
   public ResultWriter(String outputFileName)
   {
       this.outputFileName = outputFileName;
   } // end of public ResultWriter(String outputFileName)
   
   /**
     * Records result to the file.
     * 
     * @param result result
     */
   public void write(int result) throws IOException
   {
       PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileName, true));
       
       outputFile.println(result);
       
       outputFile.close();
   } // end of public void write(int result) throws IOException
} // end of public class ResultWriter
