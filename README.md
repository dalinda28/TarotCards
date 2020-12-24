# Java - TarotCards

 ## Context
 TarotCards is a Java school project carried out in December 2020.

## Architecture
-----------
| **Classes**   | **Methodes**  |
| ------------- | -----:        |
| TarotCard     | getCars, addCard, removeCard, searchCards, save |
| Card          | setDescription, setDescription |
| Action        | displayCard, addCard, editCard, removecard, searchCard, save |
| Menu          | displayChoices, quickMenu (calls an action), executeAction |
| MinorCard     | toString, editCard, getCardImage |
| MajorCard     | toString, editCard, getCardImage |
| ButtonAction  | displayChoices, quickMenu (calls an action), executeAction |

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

## Difficulty and solution
The biggest difficulty was making the interaction between interfaces and the underlying code.
The serialization works well but the deserialization JSON to object has been abandoned. 
I spent a lot of time to achieve an unconvincing result. The program with the console works very well but the interface is not yet finished due to lack of time.

## Conclusion
It's a very interesting project, it allowed me to understand a lot of things like serialization, interfaces and also many other functionalities that Eclipse hides.
