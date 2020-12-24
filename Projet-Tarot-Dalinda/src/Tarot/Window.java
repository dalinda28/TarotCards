package Tarot;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


	/**
	* This class initialize and  modifies the Main view and define event handlers for the objects.
	* 
	* @author 	Dalinda ALOUI
	*/

public class Window extends JFrame{
	private ArrayList<Card> card; //Deck of cards List

	//resolution
	int aW = 1200;
	int aH = 800;
	
	//background color 
	Color colorBackground = new Color(221,191,218);
	Color colorButton = new Color (221,191,100);
	
	//fonts
	Font fonButton = new Font("Times New Roman", Font.BOLD, 20);
	
	//Card grid positioning and dimensions 
	int gridX = 20;
	int gridY = 50;
	int gridW = 900;
	int gridH = 700;
	

	//Card dimension and spacing 
	int cardSpacing = 10;
	int cardTW = gridW/7;
	int cardTH = gridH/4;
	int cardAW = cardTW-2*cardSpacing;
	int cardAH = cardTH-2*cardSpacing;

	//Buttons
	JButton addCard = new JButton();
	JButton editCard = new JButton();
	JButton removeCard = new JButton();
	JButton searchCard = new JButton();
	JButton saveCard = new JButton();
	

	public Object num;
	protected Image image;


	public Window() throws IOException{

		this.setSize(aW,aH+30);
		this.setTitle("Tarot");
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);  
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to stop program
	    //this.setAlwaysOnTop(true); //window always on top
	    
	    Board board = new Board();
	    this.setContentPane(board);
	    this.setLayout(null);
   
	    for (int i = 30; i<50; i++) {
	    	String cardLocation = ("./src/Image/" + i + ".gif");
	    		for (int j = 0 ; j < 700; j += 170) {
		    	    MajorCard card = new MajorCard("terre", "la terre", "terreterre",ImageIO.read(new File(cardLocation)));
		    	    JLabel cardLabel = new JLabel(new ImageIcon(card.getCardImage().getScaledInstance(cardTW, cardTH, Image.SCALE_SMOOTH)));
		    	    cardLabel.setBounds(gridX+j, gridY-90, 0, 0);
			   	    cardLabel.setSize(200,400);
			   	    board.add(cardLabel);
	    		}
	    }
	    
	    /*
	    JLabel cardLabel = new JLabel(new ImageIcon(((Tarot) card).getCardImage()));
	    cardLabel.setBounds(90, 10, 120, 10);
	    cardLabel.setSize(200,400);
	    board.add(cardLabel);
	    */
	   
	    	  
	    ActAdd addButton = new ActAdd();
	    addCard.addActionListener(addButton);
	    addCard.setBounds(955, 150, 200, 50);
	    addCard.setBackground(colorButton);
	    addCard.setFont(fonButton);
	    addCard.setText("Add Card");
	    board.add(addCard);
	    
	    ActEdit editButton = new ActEdit();
	    editCard.addActionListener(editButton);
	    editCard.setBounds(955, 210, 200, 50);
	    editCard.setBackground(colorButton);
	    editCard.setFont(fonButton);
	    editCard.setText("Edit Card");
	    board.add(editCard);
	    
	    ActRemove removeButton = new ActRemove();
	    removeCard.addActionListener(removeButton);
	    removeCard.setBounds(955, 270, 200, 50);
	    removeCard.setBackground(colorButton);
	    removeCard.setFont(fonButton);
	    removeCard.setText("Remove Card");
	    board.add(removeCard);
	    
	    ActSearch searchButton = new ActSearch();
	    searchCard.addActionListener(searchButton);
	    searchCard.setBounds(955, 330, 200, 50);
	    searchCard.setBackground(colorButton);
	    searchCard.setFont(fonButton);
	    searchCard.setText("Search Card");
	    board.add(searchCard);
	    
	    ActSave saveButton = new ActSave();
	    saveCard.addActionListener(saveButton);
	    saveCard.setBounds(955, 390, 200, 50);
	    saveCard.setBackground(colorButton);
	    saveCard.setFont(fonButton);
	    saveCard.setText("Save Card");
	    board.add(saveCard);
	    
	}
	
	public class Board extends JPanel{
		  
		/**
		 * This methode contain the paintComponent
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			
			g.setColor(colorBackground);
			g.fillRect(0,  0, aW, aH);
			
			//temporary grid painting
			g.setColor(Color.black);
			g.drawRect(gridX, gridY, gridW, gridH);
			g.drawRect(gridX+920, gridY, gridW-670, gridH);
		
			/*String s = "./src/Image/" + this.toString() + ".gif";
	        image = Toolkit.getDefaultToolkit().getImage(s);
	        g.drawImage(image, 0, 0, this);*/
		}

	}
	

	public class ActAdd implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the ADD button ! ");
	        String[] options = {"Major Card", "Minor Card"};
	        JTextField nameCard = new JTextField();
	        JTextField descripCard = new JTextField();
	        JTextField typeCard = new JTextField();

	        
	        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/Image/tarot.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			String s = (String)JOptionPane.showInputDialog(
					null,
				    "What type of card do you want to add ?",
				    "Add a new card",
				    JOptionPane.INFORMATION_MESSAGE,
				    imageIcon,
				    options,
				    options[0]);
			System.out.println(s);
			int returnValue = 0;
			if (s.equals("Major Card")){
				
				returnValue = JOptionPane.showOptionDialog(null, 
					    new Object[] {"Name of card :", nameCard, "Description of the Major card :", descripCard},
					      "Connexion",
					      JOptionPane.OK_CANCEL_OPTION,
					      JOptionPane.QUESTION_MESSAGE, null, null, null); 
			}
			else{
				returnValue = JOptionPane.showOptionDialog(null, 
					    new Object[] {"Name of card :", nameCard, "Description of the Minor card :", descripCard},
					      "Connexion",
					      JOptionPane.OK_CANCEL_OPTION,
					      JOptionPane.QUESTION_MESSAGE, null, null, null); 
			}
			
			if (returnValue == JOptionPane.YES_OPTION)
	    		JOptionPane.showMessageDialog(null, "Card created !");
		}

	}
	
	
	public class ActEdit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the EDIT button ! ");
		}
	}
	
	public class ActRemove implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the REMOVE button ! ");
		}
	}
	
	public class ActSearch implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the SEARCH button ! ");
		}
	}
	
	public class ActSave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the SAVE button ! ");
		}
	}
	
}

