import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Displays a frame with text.
 *
 * @author Angela Zhou
 * @version 1
 */
public class ImageViewer6a implements ActionListener
{
    // constants
    private static final String LABEL1 = "I am a label. I can display some text";
     private static final String LABEL2 = "More text";
    
    // instance fields
    private JFrame frame;
    private JLabel label;
    private JButton button;

    /* constructors */

    /**
     * Creates an ImageViewer with a visible frame.
     */
    public ImageViewer6a()
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
    
     /**
     * Sets new text for label if action was triggered by button.
     * 
     * @param event which event triggered
     */
    public void actionPerformed(ActionEvent event)
    {
       Object source = event.getSource();
       if (source == button)
       {
           if (label.getText().equals(LABEL1))
           {
               setLabel(LABEL2);
           }
           else
           {
               setLabel(LABEL1);
           }
       }
    } // end of method setVisible(boolean shouldBeVisible)

    /* private methods */

    /*
     * Creates the application frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Image Viewer");      

        label = new JLabel(LABEL1);
        
        button = new JButton("Click me to change text");
        button.addActionListener(this);
        
        frame.add(label);
        frame.add(button, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
        label.setVisible(true);
    } // end of method makeFrame()

} // end of class ImageViewer3