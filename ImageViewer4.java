import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

/*
 * Displays a frame with text.
 *
 * @author Angela Zhou
 * @version 1
 */
public class ImageViewer4
{
    // instance fields
    private JFrame frame;
    private JLabel label;
    private JButton button;

    /* constructors */

    /**
     * Creates an ImageViewer with a visible frame.
     */
    public ImageViewer4()
    {
        makeFrame();
    } // end of constructor ImageViewer3()

    /* mutators */

    /**
     * Sets the label of this image viewer.
     * 
     * @param label the new label
     */
    public void setLabel(String label)
    {
        if (label == null) return;
        this.label.setText(label);
    } // end of method setLabel(String label)

    /**
     * Sets the visibility of frame.
     * 
     * @param shouldBeVisible if this image viewer should be visible
     */
    public void setVisible(boolean shouldBeVisible)
    {
        frame.setVisible(shouldBeVisible);
    } // end of method setVisible(boolean shouldBeVisible)
    
    /**
     * Sets the visibility of label.
     * 
     * @param shouldBeVisible shouldBeVisible if this label should be visible
     */
    public void setLabelVisible(boolean shouldBeVisible)
    {
        label.setVisible(shouldBeVisible);
    } // end of method setVisible(boolean shouldBeVisible)

    /* private methods */

    /*
     * Creates the application frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Image Viewer");      

        label = new JLabel("I am a label. I can display some text.");
        
        button = new JButton("Click me");
        
        frame.add(label);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
        label.setVisible(true);
    } // end of method makeFrame()

} // end of class ImageViewer3