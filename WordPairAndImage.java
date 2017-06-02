import java.util.Random;

/**
 * Creates a word pair in French/English with an image and its URL.
 * 
 * @author Angela Zhou
 * @version 1
 */

public class WordPairAndImage
{
	// instance fields
	private String english;
	private String french;
	private String imagePath;
	private String imageURL;

	private boolean correctlyAnswered;
	private boolean englishAsQuestion;

	/* constructors */

	/**
	 * Constructs a word pair and image with default characteristics.
	 */
	public WordPairAndImage()
	{
		this.english = "";
		this.french = "";
		this.imagePath = "";
		this.imageURL = "";
		this.correctlyAnswered = false;
	} // end of public WordPairAndImage()

	/**
	 * Randomly selects a French/English word as the question.
	 * Complimentary to <code>{@link #getAnswerWord()}</code>
	 * 
	 * @see #getAnswerWord()
	 * 
	 * @return question word
	 */
	public String getQuestionWord()
	{
		if (new Random(System.currentTimeMillis()).nextInt(2) == 1)
		{
			englishAsQuestion = true;
		}
		else
		{
			englishAsQuestion = false;
		} // end of if (new Random(System.currentTimeMillis()).nextInt(2) == 1)
		if (englishAsQuestion)
		{
			return english;
		}
		else
		{
			return french;
		} // end of if (englishAsQuestion)
	} // end of method public String getQuestionWord()

	/**
	 * Takes the unselected French/English word as the answer.
	 * Complimentary to <code>{@link #getQuestionWord()}</code>
	 * 
	 * @see #getQuestionWord()
	 * 
	 * @return answer word
	 */
	public String getAnswerWord()
	{
		if (englishAsQuestion)
		{
			return french;
		}
		else
		{
			return english;
		} // end of if (englishAsQuestion)
	} // end of method 	public String getAnswerWord()

	/**
	 * Constructs a word pair and image with all specified characteristics.
	 */
	public WordPairAndImage(String english, String french, String imagePath, String imageURL)
	{
		this.english = english;
		this.french = french;
		this.imagePath = imagePath;
		this.imageURL = imageURL;
		this.correctlyAnswered = false;
	} // end of method public WordPairAndImage(String french, String english,String imagePath)

	/* accessors */

	/**
	 * Returns the English word.
	 * 
	 * @return the English word String
	 */
	public String getEnglish()
	{
		return english;
	} // end of public String getEnglish()

	/**
	 * Returns the French word.
	 * 
	 * @return the French word.
	 */
	public String getFrench()
	{
		return french;
	} // end of public String getFrench()

	/**
	 * Returns the image path.
	 * 
	 * @return the image path.
	 */
	public String getImagePath()
	{
		return imagePath;
	} // end of public String getImagePath()

	/**
	 * Returns the image URL.
	 * 
	 * @return the image URL.
	 */
	public String getImageURL()
	{
		return imageURL;
	} // end of public String getImageURL()

	/**
	 * Returns the flag indicating whether or not this word pair has been
	 * correctly translated.
	 * 
	 * @return true if the word has been correctly translated, else false
	 */
	public boolean isCorrectlyAnswered()
	{
		return correctlyAnswered;
	} // end of public boolean isCorrectlyAnswered()

	/**
	 * Sets flag indicating whether or not this word pair has been correctly
	 * translated.
	 * 
	 * @param correct
	 *            boolean true if this word pair has been correctly translated
	 */
	public void setCorrectlyAnswered(boolean correctAnswered)
	{
		this.correctlyAnswered = correctAnswered;
	} // end of public void setCorrectlyAnswered(boolean correct)
} // end of public class WordPairAndImage

