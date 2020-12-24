package Tarot;

import java.awt.image.BufferedImage;

	/**
	 * This class creates a tarot deck using the a List/ArrayList as a 
	 * data structure to store all the cards .
	 * @author  	Dalinda ALOUI
	 */
public class TarotCards extends Card{

	private static final long serialVersionUID = 1L;
    private String type;
    
    public TarotCards(String cardName, String cardDescription, String type, BufferedImage card) {
        super(cardName, cardDescription, "Tarot", card);
        this.type = type;
    }

    public String toString() {
        String text = super.toString();
        text += "Type: " + type + "\n";
        return text;
    }

    public void editCard(String toEdit, String content) {
        super.editCard(toEdit, content);
        if (toEdit == "type") {
            type = content;
        }
    }
}