
/**
 * Displays a label with text.
 * 
 * @author Angela Zhou 
 * @version 1
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageViewer1
{
    // instance variables
    private JFrame frame;

    /**
     * Constructor for objects of class ImageViewer1
     */
    public ImageViewer1()
    {
        makeFrame();
    }

    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        JLabel label = new JLabel("I am a label. I can display some text.");
        frame.add(label);
        
        frame.pack();
        frame.setVisible(true);
    }
}
