##Explanation of the Program

The game works much like the classic game called Battleships.

The program consists of three different classes:

- DotComBust-class
- DotCom-class
- GameHelper-class.

---

##**DotComBust**

- Contains the declaration of the ArrayList that holds the 3 DotCom-objects.  

**setUpGame()-method**
- Creates and initializes the DotCom-objects with names and locations. 
- Displays brief instructions to the user. 
- Inside this method we call the placeDotCom-method from the GameHelper-class 3 times, and in return we get 3 different ArrayList's. We set each of the DotCom-objects locationCells-field to the value of those three different ArrayList's.   


**startPlaying()-method**

- This method starts the game. 
- Everything that's in this method gets repeated for as long as there still are DotCom-objects inside the ArrayList that holds them.
- This method gets userInput (user guess) by calling the getUserInput()-method in the GameHelper-class. 
- When we have received the userInput, this method calls the checkUserInput()-method in this class, to check the user guess against the location cells of all three DotCom-objects. 
- After the user have succeeded in guessing all the location cells for all three DotCom-objects, this method calls on the finishGame()-method in this class to display how many guesses it took for the user to finish.

**checkUserGuess()-method**

- This method takes the String passed from the startPlaying()-method, containing the users guessed location cell.
- The method goes through the list containing each of the three DotCom-objects. 
- For every DotCom-object in the list, we call each objects own checkYourself()-method and pass the users guess as the argument. This method will validate if the user guess is in that objects locationCells-array and return a String containing "Miss!", "Hit!" or "Kill" depending on the result. 
- If the returned String contains the word "Kill!", we specify that we should remove that specific DotCom-object. 
- At the end of this method we print the result to the user, if it was a "Miss!", "Hit!" or a "Kill".

**finishGame()-method**

- This method just prints a series of text-lines to the user to show how many guesses it took for the user to destroy all of the DotCom-objects. We use the Global variable numOfGuesses, which we increment each time the checkUserGuess()-method is called, to keep track of the score. 


---

##**DotCom**

- Contains a field for the name of the specific DotCom-object.
- Contains an ArrayList which holds each individual DotCom's location cells.

**setLocationCells()-method**

- This is just a regular Setter that sets the Object's location cells-field.

**setName()-method**

- This is just a regular Setter that sets the Object's name-field.

**checkYourself()-method**

- Each DotCom has its own checkYourself()-method.
- By using the indexOf()-method we check if the users guess is located as a value in the specific DotCom-objects location cells-array.
- If the users guess is not found in the ArrayList, the indexOf()-method will return "-1". And we will be default return "Miss!".
- If the users guess is found in the ArrayList, we remove that specific index/location cell from the ArrayList. We will instead return "Hit!".
- If the ArrayList is empty (the user have guessed all the location cells in this particular DotCom-object), we will return "Kill".



---

##**GameHelper**

This class is a story for a rainy day. 