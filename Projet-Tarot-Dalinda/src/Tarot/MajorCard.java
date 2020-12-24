package Tarot;
import java.awt.image.BufferedImage;

	/**
	 * This class is a concrete implementation of the Card class
	 * it adds a cardMessage object, that is unique to Major cards
	 * 
	 * @author  	Dalinda ALOUI
	 */

public class MajorCard extends Card {
   
	private static final long serialVersionUID = 1L;
	
	//Declaring variables unique to Major cards
	private String type;
	private BufferedImage cardImage;
	
	/**
     * Initializing the major card objects with all the needed card informations
     * @param cardName Define the name of the Major Cards
     * @param cardDescription Define the description of the card
     * @param cardType Define the type of Major card 
     * @param cardImage Define the image of the Major card
     */
	public MajorCard(String cardName, String cardDescription, String type, BufferedImage card) {
		//Calls the Card constructor
    	super(cardName, cardDescription, "Major", card);
        this.type = type;
        cardImage = card;
    }

    public String toString() {
        String text = super.toString();
        text += "Type: " + type +"\n";
        return text;
    }

    /**
     * Edit card name and description
     * @param cardName Define the name of the Major Cards
     * @param cardDescription Define the description of the card
     */
    public void editCard(String toEdit, String content) {
        super.editCard(toEdit, content);
        if (toEdit == "type") {
            type = content;
        }
    }

    /**
     * Returns the cardImage
     * @return cardImage 
     */
	public BufferedImage getCardImage() {
		return cardImage;
	}

}
