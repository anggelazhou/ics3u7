package ics3u7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;        

public class TranslationGameGUI 
{   
    /**
     * Create the GUI and show it.
     */
    private static void makeInitialFrame() 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        
        int panelWidth = 400;
        int panelHeight = 250;
        
        // Create x 
        int x = new Double((screenWidth - panelWidth) / 2).intValue();
        int y = new Double((screenHeight - panelHeight) / 2).intValue();
        
        //Create and set up the window.
        JFrame frame = new JFrame("Translation Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, panelWidth, panelHeight); 
        
		frame.getContentPane().setLayout(new BorderLayout(10, 10));
        
        JPanel instructionPanel = makeInstructionPanel(frame.getContentPane());
        frame.getContentPane().add(instructionPanel, BorderLayout.CENTER);
        

        //Display the window.
        
        frame.setVisible(true);
    }

	private static JPanel makeInstructionPanel(Container container) {
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
        button.addActionListener(new InstructionOkListener(container, instructionPanel));
        instructionPanel.add(button, BorderLayout.PAGE_END);
        
		return instructionPanel;
	}
    
	private static JPanel makeGoalPanel(Container container) {
		JPanel goalPanel = new JPanel();
        goalPanel.setLayout(new BorderLayout(10, 10));
        //panel.setBackground(Color.red);
        
        //Add the intructions.
        JLabel label = new JLabel();
        label.setBounds(50, 25, 300, 100);
        label.setText("<html><body>"
        		+ "<p>Welcome to Goal!</p>"
        		+ "<p>Instruction blabla</p>"
        		+ "</body></html>");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        label.setBorder(border);
        goalPanel.add(label, BorderLayout.CENTER);
		return goalPanel;
	}
    	

    
    private static class InstructionOkListener implements ActionListener {
    	private Container container; 
    	private JPanel instructionPanel;
    	
		public InstructionOkListener(Container container, JPanel instructionPanel) {
			this.container = container;
			this.instructionPanel = instructionPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			container.remove(instructionPanel);
			
			// build goal panel
		    JPanel goalPanel = makeGoalPanel(this.container);
		    container.add(goalPanel, BorderLayout.CENTER);
		      
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