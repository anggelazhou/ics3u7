import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Displays a frame with text.
 *
 * @author Angela Zhou
 * @version 1
 */
public class ImageViewer9
{
    // constants
    private static final String IMAGE_CREDIT = "https://blogs-images.forbes.com";
    private static final String ERROR_IMAGE_UNAVAILABLE = "Error: image unavailable";
    private static final Color BACKGROUND_COLOUR = Color.WHITE;
    private static final String FRAME_TITLE = "Image Viewer";
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    private static final String IMAGE_SOURCE = "puppy.jpg";
    private static final int DELAY = 2000;

    // instance fields
    private JFrame frame;
    private JLabel label;
    private ImageComponent image;
    private JButton disappearButton;
    private JButton quitButton;
    private JPanel buttonPanel;

    /* constructors */
    /**
     * Creates an ImageViewer with a visible frame.
     */
    public ImageViewer9()
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
     * Sets the visibility of label.
     * 
     * @param shouldBeVisible if this image viewer should be visible
     */
    public void setVisible(boolean shouldBeVisible)
    {
        frame.setVisible(shouldBeVisible);
    } // end of method setVisible(boolean shouldBeVisible)

    /**
     * Sets the visibility of frame with a delay.
     * 
     * @param shouldBeVisible shouldBeVisible if this label should be visible
     */
    public void setVisible(boolean shouldBeVisible, int delay)
    {
        if (delay < 0) return;
        try
        {
            frame.setVisible(shouldBeVisible);
            Thread.sleep(delay);
            frame.setVisible(!shouldBeVisible);
        }
        catch (InterruptedException exception)
        {
            /*
             * No action needed
             */
        }
    } // end of method setVisible(boolean shouldBeVisible)
    
    private void makeButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(BACKGROUND_COLOUR);
        
        ButtonListener actionListener = new ButtonListener();
        
        disappearButton = new JButton("disappear");
        disappearButton.addActionListener(actionListener);
        buttonPanel.add(disappearButton);
        
        quitButton = new JButton("quit");
        quitButton.addActionListener(actionListener);
        buttonPanel.add(quitButton);
    }
   
    /* private methods */
    /*
     * Creates the application frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame(FRAME_TITLE);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.getContentPane().setBackground(BACKGROUND_COLOUR);

        image = new ImageComponent(IMAGE_SOURCE);
        frame.add(image, BorderLayout.CENTER);
        JLabel imageCredit;

        if (image.getStatus() == 0)
        {
            imageCredit = new JLabel(IMAGE_CREDIT);
        }
        else
        {
            imageCredit = new JLabel(ERROR_IMAGE_UNAVAILABLE);
        } // end of if (image.getStatus() == 0)
        frame.add(imageCredit, BorderLayout.PAGE_START);

        makeButtonPanel();
        frame.add(buttonPanel, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    } // end of method makeFrame()

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            if (source == disappearButton)
            {
                setVisible(false, DELAY);
            }
            if (source == quitButton)
            {
                System.exit(0);
            }
        }
    }

    private class ImageComponent extends Component
    {
        private static final int NO_PROBLEMS_ENCOUNTERED = 0;
        private static final int PROBLEMS_ENCOUNTERED = -1;

        private BufferedImage bufferedImage;
        private int status;

        public ImageComponent(String fileName)
        {
            bufferedImage = null;
            status = NO_PROBLEMS_ENCOUNTERED;
            try
            {
                bufferedImage = ImageIO.read(new File(fileName));
            }
            catch (IOException exception)
            {
                status = PROBLEMS_ENCOUNTERED;
            }  
        }
        
        public int getStatus()
        {
            return status;
        }
        
        public void paint(Graphics graphicsContext)
        {
            graphicsContext.drawImage(bufferedImage, 0, 0, null);
        }
    }

} // end of class ImageViewer3
