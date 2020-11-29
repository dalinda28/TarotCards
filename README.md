Java - TarotCards
=======
Architecture
-----------
| **Classes**   | **Variables**         | **Methodes**  |
| ------------- |:-------------:        | -----:        |
| TarotCard     | ArrayList<Card<Card>> | getCars, addCard, removeCard, searchCards, save |
| Card          | -                     | setDescription, setDescription |
| Action        | -                     | displayCard, addCard, editCard, removecard, searchCard, save |
| Menu          | -                     | displayChoices, quickMenu (calls an action), executeAction |
