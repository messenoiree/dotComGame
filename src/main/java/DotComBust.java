import java.util.ArrayList;

public class DotComBust {

    // The DotComBust-class has three main jobs.
    // - Set up the game.
    // - Play the game until the DotCom's are dead.
    // - End the game.
    // We could map those three jobs into three methods.
    // But we choose to split the "Play the game"-method into two methods. (startPlaying() & checkUserGuess())
    // That makes it easier to test the functionality.

    // We declare and initialize the variables we'll need.
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;


    // Creates and initializes the DotCom-objects with names and locations. Displays brief instructions to the user.
    public void setUpGame(){

        // We make three DotCom-objects, give them names, and stick them in the ArrayList.
        DotCom one = new DotCom();
        one.setName("Ebay.com");
        DotCom two = new DotCom();
        two.setName("Facebook.com");
        DotCom three = new DotCom();
        three.setName("Twitter.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        // We print brief instructions for the user.
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Ebay.com, Facebook.com, Twitter.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");
        System.out.println("A-G / 0-6");

        // Repeat with each DotCom in the list.
        for(DotCom dotComToSet : dotComList){

            ArrayList<String> newLocation = helper.placeDotCom(3);      // We ask the helper for a randomly selected DotCom location.

            // - SET the location for each DotCom based on the result of the placeDotCom() call.
            dotComToSet.setLocationCells(newLocation);                          // We call the setter method on this DotCom to give it the location we just got from the helper.
        }

    }

    // Starts the game. Repeats while there are still DotCom's in the ArrayList. Gets user input and checks that input against each DotCom's location.
    public void startPlaying(){


        while(!dotComList.isEmpty()){       // Repeat as long as the DotCom list is NOT empty.

            // Get user input by calling the helper.getUserInput(). (Returns a String with users input).

            String userGuess = helper.getUserInput("Enter your guess: ");       // Get the user input.

            // Evaluate the user's input/guess by sending it to the checkUserGuess()-method.

            checkUserGuess(userGuess);      // Call our own checkUserGuess()-method.


        }

        // When the dotComList is empty, we jump out of the While-loop and the game is over.
        finishGame();       // Call our own finishGame()-method.

    }

    // Find out if there's a hit (and kill) on any DotCom.
    public void checkUserGuess(String userGuess){

        numOfGuesses++;             // We increment the number of guesses the user has made.
        String result = "Miss!";    // Assume it is a "miss", unless told otherwise.

        // Repeat with all DotCom's in the list.
        for(DotCom dotComToTest : dotComList){

            // Ask the DotCom to check the user guess, looking for a "hit" (or kill)
            result = dotComToTest.checkYourself(userGuess);     // We call the checkYourself()-method inside the DotCom-class on every DotCom in the arrayList.

            // Set the result variable to "Hit!" or "Kill!" if appropriate.
            if(result.equals("Hit!")){
                break;      // Get out of the loop early, no point in testing the others.
            }

            if(result.equals("Kill!")){
                // Remove the DotCom from the dotComList.
                dotComList.remove(dotComToTest);    // This guy is dead, so take him out of the DotCom's list.
                break;                              // Then get out of the loop.
            }

        }
        System.out.println("It was a " + result);   // Print the result for the user.
        System.out.println("\n");


    }

    // Print a message telling the user how he did in the game.
    public void finishGame(){

        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if(numOfGuesses <= 18){
            System.out.println("Congratulations, it only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        }else{
            System.out.println("Took you long enough. " + numOfGuesses + " guesses");
            System.out.println("Fish are dancing with your options.");
        }

    }

}
