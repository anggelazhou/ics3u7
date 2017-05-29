// import necessary classes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;        

/**
 * An English/French translation game.
 * 
 * @author Angela Zhou 
 * @version 1
 */

public class TranslationGameGUI 
{   
    /**
     * Create the initial frame.
     */
    private static void makeInitialFrame() 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();

        int panelWidth = 400;
        int panelHeight = 250;

        // Create x and y to center frame
        int x = new Double((screenWidth - panelWidth) / 2).intValue();
        int y = new Double((screenHeight - panelHeight) / 2).intValue();

        //Create and set up the frame.
        JFrame frame = new JFrame("Translation Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, panelWidth, panelHeight); 

        frame.getContentPane().setLayout(new BorderLayout(10, 10));

        JPanel instructionPanel = makeInstructionPanel(frame.getContentPane());
        frame.getContentPane().add(instructionPanel, BorderLayout.CENTER);

        //Display the window.
        frame.setVisible(true);
    }

     /**
     * Create the instruction panel.
     */
    private static JPanel makeInstructionPanel(Container container) 
    {
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BorderLayout(10, 10));
        //panel.setBackground(Color.red);

        //Add the intructions.
        JLabel label = new JLabel();
        label.setBounds(50, 25, 300, 100);
        label.setText("<html><body>"
            + "<p>Welcome to the French/English translation game!</p>"
            + "<p>Instruction blabla</p>"
            + "</body></html>");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        label.setBorder(border);
        instructionPanel.add(label, BorderLayout.CENTER);

        JButton button = new JButton("Next");
        button.addActionListener(new InstructionNextListener(container, instructionPanel));
        instructionPanel.add(button, BorderLayout.PAGE_END);

        return instructionPanel;
    }

     /**
     * Create goal panel.
     */
    private static JPanel makeGoalPanel(Container container) 
    {
        JPanel goalPanel = new JPanel();
        goalPanel.setLayout(new BorderLayout(10, 10));

        //Add the intructions.
        JLabel label = new JLabel();
        label.setBounds(50, 25, 300, 100);
        label.setText("<html><body>"
            + "<p>Welcome to Goal!</p>"
            + "<p>Instruction blabla</p>"
            + "</body></html>");
        //Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        //label.setBorder(border);
        goalPanel.add(label, BorderLayout.CENTER);
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

        public GoalNextListener(Container container, JPanel goalPanel) 
        {
            this.container = container;
            this.goalPanel = goalPanel;
        }

        public void actionPerformed(ActionEvent event) 
        {
            container.remove(goalPanel);

            // build game panel
            JPanel gamePanel = makeGamePanel(this.container);
            container.add(gamePanel, BorderLayout.CENTER);

            container.revalidate();
            container.repaint();
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