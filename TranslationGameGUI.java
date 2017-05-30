
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
 * An English/French translation game.
 * 
 * @author Angela Zhou 
 * @version 1
 */

public class TranslationGameGUI 
{   
    private static int frameWidth = 400;
    private static int frameHeight = 250;
    private static int horizontalGap = 10;
    private static int verticalGap = 10; 
    private static int buttonHeight = 30;
    
    /**
     * Create the initial frame.
     */
    private static void makeInitialFrame() 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();


        // Create x and y to center frame
        int x = new Double((screenWidth - frameWidth) / 2).intValue();
        int y = new Double((screenHeight - frameHeight) / 2).intValue();

        //Create and set up the frame.
        JFrame frame = new JFrame("Translation Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, frameWidth, frameHeight); 
        //frame.setSize(panelWidth, panelHeight);

        frame.getContentPane().setLayout(new BorderLayout(10, 10));

        JPanel instructionPanel = makeInstructionPanel(frame.getContentPane());
        frame.getContentPane().add(instructionPanel, BorderLayout.CENTER);

        //Display the window.
        frame.setVisible(true);
        //frame.pack();
    }

    /**
     * Calculate 
     */
    private static int calculateLabelPanelWidth()
    {
    	return frameWidth - (horizontalGap * 2);
    }
    
    /**
     * Calculate 
     */
    private static int calculateLabelPanelHeight()
    {
    	return frameHeight - (verticalGap * 2) - buttonHeight - (verticalGap * 5);
    }
    
     /**
     * Create the instruction panel.
     */
    private static JPanel makeInstructionPanel(Container container) 
    {
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BorderLayout(10, 10));
        //panel.setBackground(Color.red);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        instructionPanel.add(labelPanel, BorderLayout.CENTER);
     

        //Add the intructions.
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(calculateLabelPanelWidth(), calculateLabelPanelHeight()));
        label.setText("<html><body>"
            + "<p><center>Welcome to the French/English translation game!</center></p>"
            + "<p><center>In this game, you must translate a number of French"
            + " words to English and vice versa.</center></p>"
            + "</body></html>");
        labelPanel.add(label);
//        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
//        label.setBorder(border);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        instructionPanel.add(buttonPanel, BorderLayout.PAGE_END);
        
        JButton button = new JButton("Next");
        button.setPreferredSize(new Dimension(calculateLabelPanelWidth()/2, buttonHeight));
        button.addActionListener(new InstructionNextListener(container, instructionPanel));
        buttonPanel.add(button);

        return instructionPanel;
    }

     /**
     * Create goal panel.
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
        
        JButton button = new JButton("Next");
        button.setPreferredSize(new Dimension(calculateLabelPanelWidth()/2, buttonHeight));
        button.addActionListener(new GoalNextListener(container, goalPanel, goal));
        buttonPanel.add(button);
        
//      goal.addInputMethodListener(l);

        return goalPanel;
    }


     /**
     * Create the game panel.
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
    }

    private static class InstructionNextListener implements ActionListener
    {
        private Container container; 
        private JPanel instructionPanel;

        public InstructionNextListener(Container container, JPanel instructionPanel) 
        {
            this.container = container;
            this.instructionPanel = instructionPanel;
        }

        public void actionPerformed(ActionEvent event) 
        {
            container.remove(instructionPanel);

            // build goal panel
            JPanel goalPanel = makeGoalPanel(this.container);
            container.add(goalPanel, BorderLayout.CENTER);

            container.revalidate();
            container.repaint();
        }

    }

    private static class GoalNextListener implements ActionListener
    {
        private Container container; 
        private JPanel goalPanel;
        private JTextField goal; 

        public GoalNextListener(Container container, JPanel goalPanel, JTextField goal) 
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

            // build game panel
            JPanel gamePanel = makeGamePanel(this.container);
            container.add(gamePanel, BorderLayout.CENTER);

            container.revalidate();
            container.repaint();
            }
            else 
            {
            	JOptionPane.showMessageDialog(container.getParent(), "Invalid input. Please enter a number between 1 - 10.");
            	
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
        
    }
    

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