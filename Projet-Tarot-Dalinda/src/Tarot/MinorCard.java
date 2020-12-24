package Tarot;
import java.awt.image.BufferedImage;

	/**
	 * This class is a concrete implementation of the Card class
	 * it adds a cardDomain object, that is unique to minor cards 
	 * 
	 * @author  	Dalinda ALOUI
	 */

public class MinorCard extends Card {

	private static final long serialVersionUID = 1L;
	//Declaring variables unique to Major cards
		private String type;
		private BufferedImage cardImage;
		
		/**
	     * Initializing the minor card objects with all the needed card informations
	     * @param cardName Define the name of the Minor Cards
	     * @param cardDescription Define the description of the card
	     * @param cardType Define the type of Minor card
	     * @param cardImage Define the image of the card
	     */
	public MinorCard(String cardName, String cardDescription,String type,BufferedImage card) {
		//Calls the Card constructor
		super(cardName, cardDescription, "Minor", card);
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
     * @param cardName Define the name of the Minor Cards
     * @param cardDescription Define the description of the card
     */
    public void editCard(String toEdit, String content) {
        super.editCard(toEdit, content);
        if (toEdit == "type") {
            type = content;
        }
    }

	public BufferedImage getCardImage() {
		return cardImage;
	}
}
