import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/*
 * Displays a frame with text.
 *
 * @author Angela Zhou
 * @version 1
 */
public class CheckBox implements ItemListener
{
    // constants
    private static final String FRAME_TITLE = "Check Box";
    private static final String LABEL1 = "Hello!";
    private static final String LABEL2 = "How are you?";

    // instance fields
    private JFrame frame;
    private JLabel label;
    private JCheckBox checkBox; 

    /* constructors */
    /**
     * Creates an ImageViewer with a visible frame.
     */
    public CheckBox()
    {
        makeFrame();
    } // end of constructor ImageViewer3()

    /**
     * Sets the visibility of label.
     * 
     * @param shouldBeVisible shouldBeVisible if this label should be visible
     */
    public void setLabelVisible(boolean shouldBeVisible)
    {
        label.setVisible(shouldBeVisible);
    } // end of method setVisible(boolean shouldBeVisible)

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

    /* private methods */
    /*
     * Creates the application frame and its content.
     */

    public void itemStateChanged(ItemEvent event)
    {
        Object item = event.getItem();
        if (item instanceof JCheckBox)
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
    }

    private void makeFrame()
    {
        frame = new JFrame(FRAME_TITLE);

        label = new JLabel(LABEL1);

        checkBox = new JCheckBox("change text");
        checkBox.addItemListener(this);

        frame.add(label, BorderLayout.PAGE_START);
        frame.add(checkBox);

        frame.pack();
        frame.setVisible(true);
    } // end of method makeFrame()
}// end of class CheckBox
