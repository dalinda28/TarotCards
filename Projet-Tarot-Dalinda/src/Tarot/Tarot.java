package Tarot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

	/**
	 * This class creates a tarot deck using the a List/ArrayList as a 
	 * data structure to store all the cards .
	 * @author  	Dalinda ALOUI
	 */

public class Tarot implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cards; //Deck of cards List
	
	public Tarot() throws ClassNotFoundException, IOException {
		
		Tarot t = this.load();//Loads the deck into the List/ArrayList
        if (t != null) {
            this.cards = t.getCards();
        }
        else {
            this.cards = new ArrayList<Card>();
        }
	}

	/**
	 * This method loads the cards into the deck using readFile .
	 * it loads the List/ArrayList into the readFile.
	 * If the file is missing a file missing console message is printed.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	
	@SuppressWarnings("resource")
	private Tarot load() {
		FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/Tarot/dataCards.json");
        } catch (FileNotFoundException e) {
            return null;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            return null;
        }
        return null;
		//return ois.readObject();
	}
	
	/**
	 * This method returns card .
	 */
	ArrayList<Card> getCards() {
        return cards;
	}

	public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(int id) {
        cards.remove(id);
    }

    public Card getCard(int id) {
        return cards.get(id);
    }

    public void editCard(int id, String type, String content) {
        cards.get(id).editCard(type, content);
    }

    public void editCard(int id, String type, int content){
        cards.get(id).editCard(type, content);
    }

    public void save() {
    	
    	Gson gson = new Gson();
		JsonWriter writer = null;
    	for (int i = 0; i < cards.size(); i++) { 
    		  
			try {
				writer = new JsonWriter(new FileWriter("src/Tarot/dataCards.json"));
				gson.toJson(cards);
				
				
				System.out.println(writer);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    	/* Second method with FileOutputStream
    	try {
    		FileOutputStream fos = new FileOutputStream("YourCards.txt");
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
       
    		for (int i = 0; i < cards.size(); i++) {
    			Card card = cards.get(i);
    			oos.writeObject(card); 
    			System.out.println("Card No. " + i + " saved");
    			oos.flush();
    		}
           
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    
    public void getCardImage(int id, String chemin) {
        cards.get(id).getCardImage(chemin);
    }
}
