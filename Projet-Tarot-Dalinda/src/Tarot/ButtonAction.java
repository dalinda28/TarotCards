package Tarot;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ButtonAction {

	public class ActMajor implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the major button ! ");
		}

		public boolean isSelected() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
	public class  ActMinor implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the minor button ! ");
		}

		public boolean isSelected() {
			// TODO Auto-generated method stub
			return false;
		}

	}

	public class ActAdd implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("You just clicked the ADD button ! ");
	        String[] options = {"Major Card", "Minor Card"};
	        JTextField nameCard = new JTextField();
	        JTextField descripCard = new JTextField();
	        
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
			
			if (s.equals("Major Card")){
				JOptionPane.showOptionDialog(null, 
					    new Object[] {"Name of card :", nameCard, "Description of card :", descripCard},
					      "Connexion",
					      JOptionPane.OK_CANCEL_OPTION,
					      JOptionPane.QUESTION_MESSAGE, null, null, null); 
			}
			System.out.println("name card :" +  nameCard + "Description" + descripCard);

				
			/*
         // Declaration of object of JRadioButton class. 
            JRadioButton majorCard = new JRadioButton();
        	JRadioButton minorCard = new JRadioButton();
         // Declaration and initialization of object of "ButtonGroup" class. 
        	ButtonGroup G1 = new ButtonGroup();
            
            ActMajor majorButton = new ActMajor();
    	    majorCard.addActionListener(majorButton);
    	    majorCard.setText("Major card");
    	    G1.add(majorCard);
    	    
    	    ActMinor minorButton = new ActMinor();
    	    minorCard.addActionListener(minorButton);
    	    minorCard.setText("Minor card");
    	    G1.add(minorCard);
    	    */
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
