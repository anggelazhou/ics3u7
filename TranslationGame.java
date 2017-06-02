import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * A French/English translation game.
 * 
 * @author Angela Zhou
 * @version 1
 */

public class TranslationGame
{

	// static fields
	
	private static JFrame frame;
	
	// class constants
		private static final int buttonHeight = 30;
		private static final int frameWidth = 400;
		private static final int frameHeight = 250;
		private static final String FRAME_TITLE = "Translation Game";
		private static final int horizontalGap = 10;
		private static final String INSTRUCTION_PANEL_LABEL_TEXT = "<html><body>"
				+ "<p><center>Welcome to the French/English translation game!</center></p>"
				+ "<p><center>In this game, you must translate a number of French words"
				+ " to English and vice versa.</center></p>" + "</body></html>";
		private static final String REPLAY_BUTTON_TEXT = "Replay";
		private static final String NEXT_BUTTON_TEXT = "Next";
		private static final int NUMBER_OF_WORD_PAIRS = 5;
		private static final String QUIT_BUTTON_TEXT = "Quit";
		private static final String SUBMIT_BUTTON_TEXT = "Submit";
		private static final String WORD_LIST_TXT = "wordList.txt";
		private static final int verticalGap = 10;

	/* static methods */

	/**
	 * This application contains 4 panels:
	 * <ul>
	 * <li>instruction panel: show instruction of game with next button leading
	 * to goal panel</li>
	 * <li>goal panel: takes users goal input with next button leading to game
	 * panel</li>
	 * <li>game panel: shows image with question and asks user to answer with
	 * submit button to check whether answer is correct or not. If correct, the
	 * score increases. Once the score reaches the goal input from the goal
	 * panel, the score panel is shown.</li>
	 * <li>score panel: shows user goal, and amount of incorrectly answered word
	 * pairs.</li>
	 * </ul>
	 * 
	 * @see #makeInstructionPanel(Container)
	 * @see #makeGoalPanel(Container)
	 * @see #makeGamePanel(Container, int)
	 * @see #makeScorePanel(Container, int, int, int)
	 * 
	 * @param argument not used
	 */
	public static void main(String[] argument)
	{
		initializeFrame();
	} // end of main method public static void main(String[] argument)

	/**
	 * Creates the initial frame.
	 */
	private static void initializeFrame()
	{
		// Find screen dimensions.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();

		// Create an appropiate x and y to center frame on screen.
		int divisor = 2;
		int x = new Double((screenWidth - frameWidth) / divisor).intValue();
		int y = new Double((screenHeight - frameHeight) / divisor).intValue();

		// Create and set up the frame.
		frame = new JFrame(FRAME_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(x, y, frameWidth, frameHeight);

		frame.getContentPane().setLayout(new BorderLayout(horizontalGap,
				verticalGap));

		JPanel instructionPanel = makeInstructionPanel();
		frame.getContentPane().add(instructionPanel, BorderLayout.CENTER);

		// Display the window.
		frame.setVisible(true);
	} // end of method private static void makeInitialFrame()

	/**
	 * Calculates appropriate width of the label panel.
	 * 
	 * @return appropriate panel width
	 */
	private static int calculateLabelPanelWidth()
	{
		int multiplier = 2;
		int labelPanelWidth = frameWidth - (horizontalGap * 2);
		return labelPanelWidth;
	} // end of method private static int calculateLabelPanelWidth()

	/**
	 * Calculates appropriate height of the label panel.
	 * 
	 * @return appropriate panel height
	 */
	private static int calculateLabelPanelHeight()
	{
		int multiplier1 = 2;
		int multiplier2 = 5;
		int labelPanelHeight = frameHeight - (verticalGap * multiplier1) - 
				buttonHeight - (verticalGap * multiplier2);
		return labelPanelHeight;
	} // end of method private static int calculateLabelPanelHeight()

	/**
	 * Creates the instruction panel with next button leading to goal panel.
	 * 
	 * @see #makeGoalPanel(Container)
	 * 
	 * @return instruction panel
	 */
	private static JPanel makeInstructionPanel()
	{
		JPanel instructionPanel = new JPanel(new BorderLayout(horizontalGap, 
				verticalGap));

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		instructionPanel.add(labelPanel, BorderLayout.CENTER);

		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(calculateLabelPanelWidth(), calculateLabelPanelHeight()));
		label.setText(INSTRUCTION_PANEL_LABEL_TEXT);
		labelPanel.add(label);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		instructionPanel.add(buttonPanel, BorderLayout.PAGE_END);

		int divisor = 2;
		JButton nextButton = new JButton(NEXT_BUTTON_TEXT);
		nextButton.setPreferredSize(new Dimension
				(calculateLabelPanelWidth() / divisor, buttonHeight));
		nextButton.addActionListener(new EnterGoalPanelListener
				(instructionPanel));
		setDefaultButton(nextButton);
		buttonPanel.add(nextButton);

		return instructionPanel;
	} // end of method private static JPanel makeInstructionPanel(Container...

	/**
	 * Creates the goal panel with next button leading to game panel.
	 * 
	 * @see #makeGamePanel(Container, int)
	 * 
	 * @return goal panel
	 */
	private static JPanel makeGoalPanel()
	{
		int gridRows = 3;
		int gridColumns = 1;
		JPanel goalPanel = new JPanel(new GridLayout(gridRows, gridColumns,
				horizontalGap, verticalGap));

		// Create margins
		int topMargin = 30;
		int leftMargin = 10;
		int bottomMargin = 5;
		int rightMargin = 10;
		createMargins(goalPanel, topMargin, leftMargin, bottomMargin, rightMargin);

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		goalPanel.add(labelPanel);

		JLabel label = new JLabel("Enter a goal between 1 - " 
		+ NUMBER_OF_WORD_PAIRS + ":");
		labelPanel.add(label);

		JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,
				horizontalGap, verticalGap));
		goalPanel.add(textPanel);

		JTextField goal = new JTextField(20);
		goal.addAncestorListener(new RequestFocusListener());
		textPanel.add(goal);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		goalPanel.add(buttonPanel);

		int divisor = 3;
		JButton quitButton = createQuitButton();
		quitButton.setPreferredSize(new Dimension
				(calculateLabelPanelWidth() / divisor, buttonHeight));
		buttonPanel.add(quitButton);

		JButton nextButton = new JButton(NEXT_BUTTON_TEXT);
		nextButton.setPreferredSize(new Dimension
				(calculateLabelPanelWidth() / divisor, buttonHeight));
		nextButton.addActionListener(new GoalNextButtonListener
				(frame.getContentPane(), goalPanel, goal));
		setDefaultButton(nextButton);
		buttonPanel.add(nextButton);

		return goalPanel;
	} // end of method private static JPanel makeGoalPanel(Container container)

	/**
	 * Creates margins for panel.
	 * 
	 */
	private static void createMargins(JPanel panel, int topMargin, 
			int leftMargin, int bottomMargin, int rightMargin)
	{
		Border padding = new EmptyBorder(topMargin, leftMargin, 
				bottomMargin, rightMargin);
		panel.setBorder(padding);
	} // end of method private static void createMargins(JPanel panel, int...

	/**
	 * Creates the game panel with a submit button leading to score panel if
	 * player reaches goal, else show the next random, unanswered pair.
	 * 
	 * @see #makeScorePanel(Container, int, int, int)
	 * 
	 * @return game panel
	 */
	private static JPanel makeGamePanel(Container container, int goal)
	{
		// create game panel
		JPanel gamePanel = new JPanel(new BorderLayout());

		GamePanelSubmitButtonActionListener submitButtonListener = 
				new GamePanelSubmitButtonActionListener
				(container, gamePanel, goal);

		// Create margins
		int topMargin = 10;
		int leftMargin = 10;
		int rightMargin = 10;
		int bottomMargin = 10;
		createMargins(gamePanel, topMargin, leftMargin, bottomMargin,
				rightMargin);

		JPanel wordPairAndImagePanel = submitButtonListener.
				createPanelForNextUnansweredWordPairAndImage();
		gamePanel.add(wordPairAndImagePanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton quitButton = createQuitButton();
		buttonPanel.add(quitButton);

		JButton submitButton = new JButton(SUBMIT_BUTTON_TEXT);
		setDefaultButton(submitButton);
		buttonPanel.add(submitButton);
		submitButton.addActionListener(submitButtonListener);

		gamePanel.add(buttonPanel, BorderLayout.PAGE_END);

		return gamePanel;
	} // end of method private static JPanel makeGamePanel(Container container)

	/**
	 * Creates the score panel with a replay button leading to goal panel and a
	 * quit button to quit.
	 * 
	 * @see #makeGoalPanel(Container)
	 * 
	 * @return score panel
	 */
	private static JPanel makeScorePanel(Container container, int goal, int score, 
			int incorrectAnswerCount)
	{
		// create grid layout for the score panel
		int gridRows = 4;
		int gridColumns = 1;
		GridLayout grid = new GridLayout(gridRows, gridColumns, horizontalGap,
				verticalGap);

		// create score panel
		JPanel scorePanel = new JPanel(grid);

		// Create margins
		int topMargin = 10;
		int leftMargin = 10;
		int rightMargin = 10;
		int bottomMargin = 5;
		createMargins(scorePanel, topMargin, leftMargin, bottomMargin, 
				rightMargin);

		// create label panel
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		scorePanel.add(labelPanel);

		// create thank you label and add to the thank you label panel
		JLabel thankyouLabel = new JLabel();
		thankyouLabel.setText("Thank you for playing!");
		labelPanel.add(thankyouLabel);

		// create goal panel and add to score panel
		JPanel goalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		scorePanel.add(goalPanel);

		// create goal label and add to goal panel.
		JLabel goalLabel = new JLabel();
		goalLabel.setText("You reached your goal of " + goal + 
				" word(s).");
		goalPanel.add(goalLabel);

		JPanel missedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));
		scorePanel.add(missedPanel);
		JLabel missedLabel = new JLabel();
		missedLabel.setText("You incorrectly answered " + incorrectAnswerCount 
				+ " word(s).");
		missedPanel.add(missedLabel);

		JPanel buttonPanel = createScoreButtonPanel(scorePanel);

		scorePanel.add(buttonPanel);

		return scorePanel;
	} // end of method private static JPanel makeScorePanel(Container container,
		// int goal, int score, int incorrectAnswerCount)

	/**
	 * Creates button panel for score panel.
	 * 
	 * @return button panel for score panel
	 */
	private static JPanel createScoreButtonPanel(JPanel scorePanel)
	{
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 
				horizontalGap, verticalGap));

		JButton quitButton = createQuitButton();
		quitButton.setPreferredSize(new Dimension
				(calculateLabelPanelWidth() / 3, buttonHeight));
		buttonPanel.add(quitButton);

		JButton replayButton = new JButton(REPLAY_BUTTON_TEXT);
		replayButton.setPreferredSize(new Dimension
				(calculateLabelPanelWidth() / 3, buttonHeight));
		setDefaultButton(replayButton);
		replayButton.addActionListener(new EnterGoalPanelListener(scorePanel));

		buttonPanel.add(replayButton);

		return buttonPanel;
	} // end of private static method JPanel createScoreButtonPanel(JPanel
		// scorePanel)

	/**
	 * Creates the quit button.
	 * 
	 * @return quit button
	 */
	private static JButton createQuitButton()
	{
		JButton quitButton = new JButton(QUIT_BUTTON_TEXT);
		quitButton.addActionListener(new QuitButtonListener());

		return quitButton;
	} // end of method private static JButton createQuitButton()

	/**
	 * Sets default button for panel.
	 * 
	 * @return appropriate panel height
	 */
	private static void setDefaultButton(JButton button)
	{
		frame.getRootPane().setDefaultButton(button);
	} // end of method private static void setDefaultButton(JButton button)

	/* private classes */

	/*
	 * A listener which can be registered by an event source and which can
	 * receive event objects.
	 */
	private static class EnterGoalPanelListener implements ActionListener
	{
		private JPanel previousPanel;

		/*
		 * Constructs an object instance holding the previous panel's reference
		 * (in order to remove when rendering goal panel)
		 */
		public EnterGoalPanelListener(JPanel previousPanel)
		{
			this.previousPanel = previousPanel;
		} // end of constructor public EnterGoalPanelListener(JPanel
			// previousPanel)

		/*
		 * Responds to button events.
		 */
		public void actionPerformed(ActionEvent event)
		{
			frame.getContentPane().remove(previousPanel);

			// build the goal panel
			JPanel goalPanel = makeGoalPanel();
			frame.getContentPane().add(goalPanel, BorderLayout.CENTER);

			// refresh the frame
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		} // end of method public void actionPerformed(ActionEvent event)

	} // end of class private static class EnterGoalPanelListener implements
		// ActionListener

	/*
	 * A listener which can be registered by an event source and which can
	 * receive event objects.
	 */
	private static class GoalNextButtonListener implements ActionListener
	{
		private Container container;
		private JPanel goalPanel;
		private JTextField goal;

		/*
		 * Constructs an object instance holding the container, goal panel, and
		 * goal text field's instance.
		 */
		public GoalNextButtonListener(Container container, JPanel goalPanel, 
				JTextField goal)
		{
			this.container = container;
			this.goalPanel = goalPanel;
			this.goal = goal;
		} // end of constructor public GoalNextButtonListener(Container
			// container, JPanel goalPanel, JTextField goal)

		/*
		 * Checks if input is valid.
		 */
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
					if (value >= 1 && value <= NUMBER_OF_WORD_PAIRS)
					{
						return true;
					}
					else
					{
						return false;
					} // end of if (value >= 1 && value <= ...
				} // end of if (input == null || input.length() == 0)
				catch (Exception exception)
				{
					return false;
				} // end of catch (Exception exception)
			} // end of if (input == null || input.length() == 0)

		} // end of method private boolean isInputValid()

		/*
		 * Responds to button events.
		 */
		public void actionPerformed(ActionEvent event)
		{
			if (isInputValid())
			{
				String goalInput = goal.getText().trim();
				container.remove(goalPanel);

				// build the game panel
				JPanel gamePanel = makeGamePanel(this.container, 
						Integer.parseInt(goalInput));
				container.add(gamePanel, BorderLayout.CENTER);

				// refresh the frame
				container.revalidate();
				container.repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(container.getParent(),
						"Invalid input. Please enter a number between 1 - " 
				+ NUMBER_OF_WORD_PAIRS + ".");
			} // end of if (isInputValid())
		} // end of method public void actionPerformed(ActionEvent event)

	} // end of class private static class GoalNextButtonListener implements...

	/*
	 * A listener which can be registered by an event source and which can
	 * receive event objects.
	 */
	private static class GamePanelSubmitButtonActionListener 
		implements ActionListener
	{
		private Container container;
		private JPanel gamePanel;
		private JPanel wordPairAndImagePanel;
		private WordListManager wordListManager;
		private WordPairAndImage wordPairAndImage;
		private JTextField answerInput;
		private int goal;
		private int score;
		private int incorrectAnswerCount;

		/*
		 * Constructs an object instance holding the container, game panel, and
		 * goal reference.
		 */
		public GamePanelSubmitButtonActionListener(Container container, 
				JPanel gamePanel, int goal)
		{
			this.container = container;
			this.gamePanel = gamePanel;
			this.goal = goal;
			this.score = 0;
			this.incorrectAnswerCount = 0;

			ArrayList<WordPairAndImage> wordPairAndImages = readWordList();
			wordListManager = new WordListManager(wordPairAndImages);
		} // end of constructor public
			// GamePanelSubmitButtonActionListener(Container container...

		/*
		 * Responds to button events.
		 */
		public void actionPerformed(ActionEvent event)
		{
			String userInput = answerInput.getText().trim();
			String expectedInput = wordPairAndImage.getAnswerWord();
			if (userInput.length() == 0)
			{
				JOptionPane.showMessageDialog(container.getParent(), 
						"Please enter input.");
			}
			else if (expectedInput.equalsIgnoreCase(userInput))
			{
				score++;
				wordPairAndImage.setCorrectlyAnswered(true);
				if (score >= goal)
				{
					// remove gamePanel
					container.remove(gamePanel);

					// show goal reporting panel
					JPanel scorePanel = makeScorePanel(this.container, goal, 
							score, incorrectAnswerCount);
					container.add(scorePanel, BorderLayout.CENTER);

					// refresh the frame
					container.revalidate();
					container.repaint();
				}
				else
				{
					showNextWordPairAndImage();
				} // end of if (score >= goal)
			}
			else
			{
				JOptionPane.showMessageDialog(container.getParent(), 
						"<html><center><p>Sorry, incorrect.</p>"
						+ "<p>Correct answer: " + wordPairAndImage.getAnswerWord() 
						+ "</p></center></html>");
				incorrectAnswerCount++;
				showNextWordPairAndImage();
			} // end of if (userInput.length() == 0)
		} // end of method public void actionPerformed(ActionEvent event)

		/*
		 * Shows new word pair and image when user.
		 */
		private void showNextWordPairAndImage()
		{
			// remove old wordPairAndImagePanel
			gamePanel.remove(wordPairAndImagePanel);

			// build new wordPairAndImagePanel with new question
			wordPairAndImagePanel = 
					createPanelForNextUnansweredWordPairAndImage();
			gamePanel.add(wordPairAndImagePanel, BorderLayout.CENTER);

			// refresh the game panel
			gamePanel.revalidate();
			gamePanel.repaint();
		} // end of method private void showNextWordPairAndImage()

		/*
		 * Creates panel to show new word pair and image.
		 */
		public JPanel createPanelForNextUnansweredWordPairAndImage()
		{
			wordPairAndImage = wordListManager.getRandomUnansweredWordPair();

			wordPairAndImagePanel = new JPanel(new BorderLayout());

			JLabel imageCredit = new JLabel(
					"<html><p><font size='1'>credit:" + wordPairAndImage.getImageURL() 
					+ "</font></p></html>",
					SwingConstants.CENTER);
			wordPairAndImagePanel.add(imageCredit, BorderLayout.PAGE_START);

			BufferedImage image = readImage(wordPairAndImage.getImagePath());
			ImageIcon imageIcon = new ImageIcon(image);
			JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
			wordPairAndImagePanel.add(imageLabel, BorderLayout.CENTER);

			int rows = 2;
			int columns = 1;
			JPanel wordPairPanel = new JPanel(new GridLayout(rows, columns, 
					horizontalGap, verticalGap));
			wordPairAndImagePanel.add(wordPairPanel, BorderLayout.PAGE_END);

			JLabel questionLabel = new JLabel(wordPairAndImage.getQuestionWord(), 
					SwingConstants.CENTER);
			wordPairPanel.add(questionLabel);

			answerInput = new JTextField();
			answerInput.addAncestorListener(new RequestFocusListener());
			wordPairPanel.add(answerInput);

			return wordPairAndImagePanel;
		} // end of method public JPanel...

		/*
		 * Reads the word list from a text file.
		 */
		private ArrayList<WordPairAndImage> readWordList()
		{
			ArrayList<WordPairAndImage> wordPairAndImages = new ArrayList<>();

			try (InputStream inputStream = 
					TranslationGame.class.getResourceAsStream(WORD_LIST_TXT))
			{
				Properties properties = new Properties();
				properties.load(inputStream);

				int index = 1;
				boolean found = true;
				do
				{
					String english = properties.getProperty("word" + index 
							+ ".english");
					String french = properties.getProperty("word" + index 
							+ ".french");
					String imagePath = properties.getProperty("word" + index
							+ ".image");
					String imageURL = properties.getProperty("word" + index 
							+ ".imageURL");
					if (english == null)
					{
						// stop parsing
						found = false;
					}
					else
					{
						WordPairAndImage wordPairAndImage = new WordPairAndImage
								(english, french, imagePath, imageURL);
						wordPairAndImages.add(wordPairAndImage);
						index++;
					} // end of if (english == null)
				}
				while (found);

				return wordPairAndImages;
			}
			catch (IOException exception)
			{
				throw new RuntimeException("Failed to parse file: " 
						+ WORD_LIST_TXT, exception);
			} // end of catch (IOException exception)
		} // end of method private ArrayList<WordPairAndImage> readWordList()

		/*
		 * Reads the image
		 */
		private BufferedImage readImage(String imageResource)
		{
			try (InputStream inputStream = 
					TranslationGame.class.getResourceAsStream(imageResource))
			{
				BufferedImage image = ImageIO.read(inputStream);
				return image;
			}
			catch (IOException exception)
			{
				throw new RuntimeException("fail to read image resource: " 
			+ imageResource, exception);
			} // end of catch (IOException exception)
		} // end of method private static BufferedImage readImage(String...
	} // end of class private static class
		// GamePanelSubmitButtonActionListener...

	/*
	 * Requests focus listener for text fields.
	 */
	private static class RequestFocusListener implements AncestorListener
	{
		private boolean removeListener;

		/*
		 * Convenience constructor. The listener is only used once and then it
		 * is removed from the component.
		 */
		public RequestFocusListener()
		{
			this(true);
		} // end of constructor public RequestFocusListener()

		/*
		 * Constructor that controls if this listen can be used once or
		 *  multiple times.
		 *
		 * @param removeListener true when this listener is only invoked once,
		 * else it can be invoked multiple times.
		 */
		public RequestFocusListener(boolean removeListener)
		{
			this.removeListener = removeListener;
		} // end of constructor public RequestFocusListener(boolean...

		public void ancestorAdded(AncestorEvent event)
		{
			JComponent component = event.getComponent();
			component.requestFocusInWindow();

			if (removeListener)
			{
				component.removeAncestorListener(this);
			} // end of if (removeListener)
		} // end of method public void ancestorAdded(AncestorEvent event)

		public void ancestorMoved(AncestorEvent event)
		{
		} // end of method public void ancestorMoved(AncestorEvent event)

		public void ancestorRemoved(AncestorEvent event)
		{
		} // end of method public void ancestorRemoved(AncestorEvent event)
	} // end of private static class RequestFocusListener implements...

	/*
	 * Holds a list of word pairs and randomly generates next unanswered pair.
	 */
	private static class WordListManager
	{
		private ArrayList<WordPairAndImage> wordPairAndImages;
		private Random random;

		/*
		 * Constructs word list and image list.
		 */
		public WordListManager(ArrayList<WordPairAndImage> wordPairAndImages)
		{
			this.wordPairAndImages = wordPairAndImages;
			random = new Random(System.currentTimeMillis());
		} // end of constructor public
			// WordListManager(ArrayList<WordPairAndImage> wordPairAndImages)

		/*
		 * Gets random unanswered or incorrectly answered word pair.
		 */
		public WordPairAndImage getRandomUnansweredWordPair()
		{
			WordPairAndImage nextPair = null;
			while (nextPair == null || nextPair.isCorrectlyAnswered())
			{
				int index = random.nextInt(wordPairAndImages.size());
				nextPair = wordPairAndImages.get(index);
			} // end of while (nextPair == null ||
				// nextPair.isCorrectlyAnswered())
			return nextPair;
		} // end of accessor public WordPairAndImage...
	} // end of class private static class WordListManager...

	/*
	 * A listener which can be registered by an event source and which can
	 * receive event objects.
	 */
	private static class QuitButtonListener implements ActionListener
	{
		/*
		 * Responds to quit button events.
		 */
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		} // end of public void actionPerformed(ActionEvent event)
	} // end of class private static class QuitButtonListener implements...
} // end of public class TranslationGame