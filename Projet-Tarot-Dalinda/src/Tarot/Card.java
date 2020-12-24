package Tarot;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *This class is used to create two types of cards a major card and a minor card. 
 *@author 	Dalinda ALOUI
 */

public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	//Declaring common card variables

	protected String cardName;
    protected String cardDescription;
    protected String cardType;
    protected BufferedImage cardImage;

    /**
     * Initializing the card objects with all the needed card informations
     * @param cardName Define the name of the Tarot Cards
     * @param cardDescription Define the description of the card
     * @param cardType Define the type of card (Major or Minor card)
     * @param cardImage Define the image of the card
     */

    public Card(String cardName, String cardDescription, String cardType, BufferedImage card) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardType = cardType;
        this.cardImage = card;
    }
    
    /**
     * Edit card name and description
     * @param cardName Define the name of the Tarot Cards
     * @param cardDescription Define the description of the card
     */
    public void editCard(String toEdit, String content) {
        if (toEdit == "name") {
            cardName = content;
        }
        else if (toEdit == "description") {
            cardDescription = content;
        }
    }

    public void editCard(String toEdit, int content) {}

    /**
     * Get name of card
     * @return cardName 
     */
    public String getCardName() {
        return this.cardName;
    }

    /**
     * Returns the cardType
     * @return cardType 
     */
    public String getCardType() {
        return this.cardType;
    }
    
    /**
     * Returns the cardImage
     * @return cardImage 
     */
    public BufferedImage getCardImage(String chemin) {
        return this.cardImage;
    }

    @Override
    public String toString(){
        String text = cardType + " card" + "\n";
        text += "Name: " + cardName + "\n";
        text += "Description: " + cardDescription + "\n";
        text += "Location of the image : " + cardImage + "\n";

        return text;
    }

}
