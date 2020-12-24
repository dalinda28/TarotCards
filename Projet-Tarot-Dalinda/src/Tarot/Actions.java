package Tarot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.imageio.ImageIO;

	/**
	 * This class initialize and  modifies the Reading view and define event handlers for the objects.
	 * @author  	Dalinda ALOUI
	 */

public class Actions {
	 private Tarot tarot;
	 private Scanner input;
	 private BufferedImage image; 
	
	 public Actions() throws ClassNotFoundException, IOException {
	        this.tarot= new Tarot();
	        input = new Scanner(System.in);
	 }
	 
	 private int promptInt(){
	        boolean done = false;
	        int number = 0;
	        do {
	            try {
	                number = input.nextInt();
	                done = true;
	            }
	            catch (InputMismatchException e) {
	                System.out.println("Please enter a valid number");
	                input.next();
	            }
	        } while (!done);

	        //consume the /n from the input.nextInt() call, see https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
	        input.nextLine();

	        return number;
	    }

		/**
		 * This method  display the cards
		 * @param name the name of the cards 
		 */
	    @SuppressWarnings("null")
		public void displayCards() {
	        ArrayList<Card> cards = tarot.getCards();

	        if (cards.size() == 0) {
	            Card card = null;
	            System.out.println("Your tarotdeck is empty");
	        }

	        for (int i = 0; i < cards.size(); i++) {
	            Card card = cards.get(i);
	            System.out.println("Card No. " + (i+1) + ":");
	            System.out.println(card.toString());
	        }
           

	    }

	    /**
		 * This method add the cards (major or minor)
		 * @param name  the name of the card
		 * @param description  the description of the card
		 * @param location  the location of the card
		 * @param image  the image of the card 
		 */ 
	    public void addCard() {
	        System.out.println("What type of card do you want to add ?");
	        System.out.println("1 - Major card");
	        System.out.println("2 - Minor card");
	        int nb = promptInt();

	        String type = "";
	        switch (nb) {
	            case 1:
	                type = "Major";
	                break;
	            case 2:
	                type = "Minor";
	                break;
	            default:
	                type = "Major";
	        }

	        System.out.println("Enter your card's name :");
	        String name = input.nextLine();
	        while (name.length() == 0) {
	            System.out.println("The name can't be empty");
	            name = input.nextLine();
	        }

	        System.out.println("Enter the description of your card :");
	        String description = input.nextLine();
	        while (description.length() == 0) {
	            System.out.println("The descripton can't be empty");
	            description = input.nextLine();
	        }
	        System.out.println("Enter the location of the image :");
	        String location = input.nextLine();
	        while (location.length() == 0) {
	            System.out.println("The location can't be empty");
	            location = input.nextLine();
	        }

	        Card card = null;
	        if (type == "Major") {
	            card = MajorCard(name, description, image);
	        }
	        else if (type == "Minor") {
	            card = MinorCard(name, description, image);
	        }

	        tarot.addCard(card);
	        System.out.println("Your card was successfully added to your deck !");
	    }

	    /**
	     * Create a new MajorCard
	     * @param name Define the name of the card
	     * @param description Define the description of the card
	     * @param type Define the type of card.
	     */
	    private Card MajorCard(String name, String description, BufferedImage image) {
	        System.out.println("Enter your Major card's type :");
	        String type = input.nextLine();
	        while (type.length() == 0) {
	            System.out.println("The type can't be empty");
	            type = input.nextLine();
	        }

	        return new MajorCard(name, description, type, null);
	    }

	    /**
	     * Create a new MinorCard
	     * @param name Define the name of the card
	     * @param description Define the description of the card
	     * @param type Define the type of card.
	     */
	    private Card MinorCard(String name, String description, BufferedImage image) {
	    	System.out.println("Enter your Minor card's type");
	        String type = input.nextLine();
	        while (type.length() == 0) {
	            System.out.println("The type can't be empty");
	            type = input.nextLine();
	        }
	        return new MinorCard(name, description,type, null);
	    }

	    /**
		 * This method remove cards
		 */
	    public void removeCard() {
	        if (tarot.getCards().size() == 0) {
	            System.out.println("Your deck is empty");
	            return;
	        }

	        System.out.println("Enter the number of the card you want to remove, or enter 0 to go back:");

	        int cardNumber = promptInt();

	        if (cardNumber == 0) {
	            return;
	        }
	        if (cardNumber >= 1 && cardNumber <= tarot.getCards().size()) {
	        	tarot.removeCard((cardNumber-1));
	            System.out.println("The card was removed from you deck");
	        }
	    }

	    /**
		 * This method edit cards
		 * @param name cardNumber 
		 */
	    public void editCard() {
	        if (tarot.getCards().size() == 0) {
	            System.out.println("Your deck is empty");
	            return;
	        }

	        System.out.println("Enter the number of the card you want to edit, or enter 0 to go back:");

	        int cardNumber = promptInt();

	        if (cardNumber == 0) {
	            return;
	        }
	        if (cardNumber >= 1 && cardNumber <= tarot.getCards().size()) {
	            Card card = tarot.getCard((cardNumber-1));

	            System.out.println("Editing card No. " + cardNumber + ", " + card.getCardType() + " card");
	            System.out.println("0 - Go back");
	            System.out.println("1 - Name");
	            System.out.println("2 - Description");
	            if (card.getCardType() == "Major" || card.getCardType() == "Minor") {
	                System.out.println("3 - Type");
	            }

	            int choice = promptInt();

	            if (choice == 0) return;

	            int maxChoice = 2;

	            switch (card.getCardType()) {
	                case "Major":
	                    maxChoice = 4;
	                    break;
	                case "Minor":
	                    maxChoice = 3;
	                    break;
	            }

	            while (choice < 1 || choice > maxChoice) {
	                choice = promptInt();
	                System.out.println("Enter a valid number");
	            }

	            String toEdit = "";
	            switch(choice) {
	                case 1:
	                    toEdit = "name";
	                    break;
	                case 2:
	                    toEdit = "description";
	                    break;
	                case 3:
	                    toEdit = "type";
	                    break;
	            }

	             
	                String content = input.nextLine();
	                tarot.editCard((cardNumber-1), toEdit, content);
	            
	        }
	    }

	    /**
		 * This method search cards
		 * @param name cardNumber 
		 */
	    public void searchCard() {
	        ArrayList<Card> cards = tarot.getCards();

	        System.out.println("Search a card");
	        System.out.println("1 - By name");
	        System.out.println("2 - By number");

	        int choice = promptInt();

	        if (choice == 1) {
	            System.out.println("Type the name you want to search for:");
	            String search = input.nextLine();
	            cards.removeIf(c -> !c.getCardName().contains(search));
	            if (cards.size() > 0) {
	                System.out.println("Results:");
	                for (int i = 0; i < cards.size(); i++) {
	                    Card card = cards.get(i);
	                    System.out.println((i+1) + ":");
	                    System.out.println(card.toString());
	                }
	            }
	            else {
	                System.out.println("No results for this search");
	            }
	        }
	        else if(choice == 2) {
	            System.out.println("Type the number you want to search for:");
	            int search = promptInt();
	            if (search >= 1 && search <= cards.size()) {
	                System.out.println(cards.get((search-1)).toString());
	            }
	            else {
	                System.out.println("This card does not exist");
	            }

	        }
	    }

	    /**
		 * This method TO save cards
		 * @param name tarot 
		 */
	    public void save() {
	    	tarot.save();
	        System.out.println("Your deck has been saved");
	    }
	    
	    /**
		 * This method TO save image card
		 * @param  name image: an absolute chemin giving the base location of the image
		 */
	    public void getCardImage(String chemin) {
	    	try {
				image = ImageIO.read(new File(chemin));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
}
