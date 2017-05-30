// import necessary classes
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;        

/**
 * A French/English translation game.
 * 
 * @author Angela Zhou 
 * @version 1
 */

public class TranslationGameGUI 
{   
    // static fields
    private static int frameWidth = 400;
    private static int frameHeight = 250;
    private static int horizontalGap = 10;
    private static int verticalGap = 10; 
    private static int buttonHeight = 30;
    private static String FRAME_TITLE = "Translation Game";
    private static String NEXT_BUTTON_TEXT = "Next";
    private static String INSTRUCTION_PANEL_LABEL_TEXT = "<html><body>"
            + "<p><center>Welcome to the French/English translation game!</center></p>"
            + "<p><center>In this game, you must translate a number of French words"
            + " to English and vice versa.</center></p>"
            + "</body></html>";
    private static int verticalGap = 10;
    private static int horizontalGap = 10;


    /**
     * Creates the initial frame.
     */
    private static void makeInitialFrame() 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();

        // Create an appropiate x and y to center frame on screen.
        int x = new Double((screenWidth - frameWidth) / 2).intValue();
        int y = new Double((screenHeight - frameHeight) / 2).intValue();

        //Create and set up the frame.
        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, frameWidth, frameHeight); 
        //frame.setSize(panelWidth, panelHeight);

        frame.getContentPane().setLayout(new BorderLayout(10, 10));

        JPanel instructionPanel = makeInstructionPanel(frame.getContentPane());
        frame.getContentPane().add(instructionPanel, BorderLayout.CENTER);

        //Display the window.
        frame.setVisible(true);
        //frame.pack();
    } // end of method private static void makeInitialFrame() 

    /**
     * Calculates appropriate width of the label panel.
     */
    private static int calculateLabelPanelWidth()
    {
        return frameWidth - (horizontalGap * 2);
    } // end of method private static int calculateLabelPanelWidth()

    /**
     * Calculates appropriate height of the label panel.
     */
    private static int calculateLabelPanelHeight()
    {
        return frameHeight - (verticalGap * 2) - buttonHeight - (verticalGap * 5);
    } // end of method private static int calculateLabelPanelHeight()

    /**
     * Creates the instruction panel.
     */
    private static JPanel makeInstructionPanel(Container container) 
    {
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BorderLayout(10, 10));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        instructionPanel.add(labelPanel, BorderLayout.CENTER);

        //Add the intructions.
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(calculateLabelPanelWidth(), 
            calculateLabelPanelHeight()));
        label.setText(INSTRUCTION_PANEL_LABEL_TEXT);
        labelPanel.add(label);
        //        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        //        label.setBorder(border);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        instructionPanel.add(buttonPanel, BorderLayout.PAGE_END);

        JButton button = new JButton(NEXT_BUTTON_TEXT);
        button.setPreferredSize(new Dimension(calculateLabelPanelWidth()/2, buttonHeight));
        button.addActionListener(new InstructionNextButtonListener(container, instructionPanel));
        buttonPanel.add(button);

        return instructionPanel;
    } // end of method private static JPanel makeInstructionPanel(Container container)

    /**
     * Creates the goal panel.
     */
    private static JPanel makeGoalPanel(Container container) 
    {
        GridLayout grid = new GridLayout(3, 1, 10, 10);

        JPanel goalPanel = new JPanel();
        goalPanel.setLayout(grid);

        Border paddingBorder = new EmptyBorder(30, 10, 5, 10);
        goalPanel.setBorder(paddingBorder);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        goalPanel.add(labelPanel);

        JLabel label = new JLabel();
        label.setText("Enter a goal between 1 - 10:");
        labelPanel.add(label);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        goalPanel.add(textPanel);

        JTextField goal = new JTextField(20);
        textPanel.add(goal);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        goalPanel.add(buttonPanel);

        JButton button = new JButton(NEXT_BUTTON_TEXT);
        button.setPreferredSize(new Dimension(calculateLabelPanelWidth()/2, buttonHeight));
        button.addActionListener(new GoalNextButtonListener(container, goalPanel, goal));
        buttonPanel.add(button);

        //      goal.addInputMethodListener(l);

        return goalPanel;
    } // end of method private static JPanel makeGoalPanel(Container container)

    /**
     * Creates the game panel.
     */
    private static JPanel makeGamePanel(Container container) 
    {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout(10, 10));

        //Add the intructions.
        JLabel label = new JLabel();
        label.setBounds(50, 25, 300, 100);
        label.setText("<html><body>"
            + "<p>Welcome to Game!</p>"
            + "<p>Instruction blabla</p>"
            + "</body></html>");
        //Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        //label.setBorder(border);
        gamePanel.add(label, BorderLayout.CENTER);

        JButton button = new JButton("Submit");
        gamePanel.add(button, BorderLayout.PAGE_END);

        return gamePanel;
    } // end of method private static JPanel makeGamePanel(Container container)

    /*
     * A listener which can be registered by an event source and which
     * can receive event objects.
     */
    private static class InstructionNextButtonListener implements ActionListener
    {
        private Container container; 
        private JPanel instructionPanel;

        public InstructionNextButtonListener(Container container, JPanel instructionPanel) 
        {
            this.container = container;
            this.instructionPanel = instructionPanel;
        }

        public void actionPerformed(ActionEvent event) 
        {
            container.remove(instructionPanel);

            // build the goal panel
            JPanel goalPanel = makeGoalPanel(this.container);
            container.add(goalPanel, BorderLayout.CENTER);

            container.revalidate();
            container.repaint();
        }

    } // end of class private static class InstructionNextButtonListener implements ActionListener

     /*
     * A listener which can be registered by an event source and which
     * can receive event objects.
     */
    private static class GoalNextButtonListener implements ActionListener
    {
        private Container container; 
        private JPanel goalPanel;
        private JTextField goal; 

        public GoalNextButtonListener(Container container, JPanel goalPanel, JTextField goal) 
        {
            this.container = container;
            this.goalPanel = goalPanel;
            this.goal = goal; 
        }

        public void actionPerformed(ActionEvent event) 
        {
            if (isInputValid()) 
            {

                container.remove(goalPanel);

                // build the game panel
                JPanel gamePanel = makeGamePanel(this.container);
                container.add(gamePanel, BorderLayout.CENTER);

                container.revalidate();
                container.repaint();
            }
            else 
            {
                JOptionPane.showMessageDialog(container.getParent(), 
                    "Invalid input. Please enter a number between 1 - 10.");
            }
        }

        private boolean isInputValid()
        {
            String input = goal.getText();
            if (input == null || input.length() == 0)
            {
                return false;
            }
            else 
            {
                input = input.trim();
                try
                {
                    int value = Integer.parseInt(input);
                    if ( value >= 1 && value <= 10 ) 
                    {
                        return true;
                    } 
                    else
                    {
                        return false;
                    }
                }
                catch (Exception exception)
                {
                    return false;
                }
            }

        }

    } // end of class  private static class GoalNextButtonListener implements ActionListener

    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    makeInitialFrame();
                }
            });
    }
}