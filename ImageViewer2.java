
/**
 * Displays a label with text.
 * 
 * @author Angela Zhou 
 * @version 1
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageViewer2
{
    // instance variables
    private JFrame frame;

    /**
     * Constructor for objects of class ImageViewer1
     */
    public ImageViewer2()
    {
        makeFrame();
    }
    
     private void makeFrame()
    {
        frame = new JFrame("ImageViewer2");
        JLabel label = new JLabel("I am a label. I can display some text.");
        frame.add(label);
        
        frame.pack();
    }
   
     /**
     * Sets visibility of frame.
     * 
     * @param shoudBeVisible whether frame is visible or not
     */
    public void setVisible(boolean shouldBeVisible)
    {
        frame.setVisible(shouldBeVisible);
    }
}
