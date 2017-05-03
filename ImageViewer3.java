import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Displays a frame with text.
 *
 * @author Angela Zhou
 * @version 1
 */
public class ImageViewer3
{
    // instance fields
    private JFrame frame;
    private JLabel label;

    /* constructors */

    /**
     * Creates an ImageViewer with a visible frame.
     */
    public ImageViewer3()
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
     * Sets the visibility.
     * 
     * @param shouldBeVisible <code>true</code>, if this image viewer should
     * be visible; otherwise <code>false</code>
     */
    public void setVisible(boolean shouldBeVisible)
    {
        frame.setVisible(shouldBeVisible);
    } // end of method setVisible(boolean shouldBeVisible)

    /* private methods */

    /*
     * Creates the application frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Image Viewer");      

        label = new JLabel("I am a label. I can display some text.");
        frame.add(label);

        frame.pack();
        frame.setVisible(true);
    } // end of method makeFrame()

} // end of class ImageViewer3