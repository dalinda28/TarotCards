# Java - TarotCards

 ## Contexte 
 TarotCards est un projet scolaire Java réalisé en Décembre 2020 .

## Architecture
-----------
| **Classes**   | **Variables**         | **Methodes**  |
| ------------- |:-------------:        | -----:        |
| TarotCard     | ArrayList<Card<Card>> | getCars, addCard, removeCard, searchCards, save |
| Card          | -                     | setDescription, setDescription |
| Action        |  tarot(Tarot) / input(Scanner) / image(BufferedImage) | displayCard, addCard, editCard, removecard, searchCard, save |
| Menu          | -                     | displayChoices, quickMenu (calls an action), executeAction |
| MinorCard     | -                     | toString, editCard, getCardImage |
| MajorCard     | -                     | toString, editCard, getCardImage |
| ButtonAction  | -                     | displayChoices, quickMenu (calls an action), executeAction |
| Window        | -                     | Board |


**Main :**
This class initialize and modifies the Main view and define event handlers for the objects.<br/>
**Menu :**	
This class initialize and modifies the Deck view .<br/>
**Tarot :**	
This class creates a tarot deck using the a List/ArrayList as a data structure to store all the cards .<br/>
**TarotCards :**	
This class creates a tarot deck using the a List/ArrayList as a data structure to store all the cards .<br/>
**Actions :**
This class initialize and modifies the Reading view and define event handlers for the objects.<br/>
**Card :**
This class is used to create two types of cards a major card and a minor card.<br/>
**MajorCard :**	
This class is a concrete implementation of the Card class it adds a cardMessage object, that is unique to major cards.<br/>
**MinorCard :**	
This class is a concrete implementation of the Card class it adds a cardDomain object, that is unique to major cards.<br/>
**Window :**	
This class initialize and modifies the Main view and define event handlers for the objects.<br/>


## L'interface utilisateur

## Difficulté et solution
La plus grande difficulté a été de faire l’interaction entre interfaces et code sous-jacent.

Je passais beaucoup de temps pour arriver un résultat peu convaincant.

La sérialisation en JSON a été abandonnée malgré la facilité d'intégration avec GSON. L'importation de GSON.jar 

## Conclusion
