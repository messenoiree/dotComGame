import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    // This ArrayList will contain all the DotCom-objects.
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;


    // Creates and initializes the DotCom-objects with names and locations. Displays brief instructions to the user.
    public void setUpGame(){

        DotCom one = new DotCom();
        one.setName("Ebay.com");
        DotCom two = new DotCom();
        two.setName("Facebook.com");
        DotCom three = new DotCom();
        three.setName("Twitter.com");

        // Add the objects the ArrayList
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        // Print brief instructions for the user
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Ebay.com, Facebook.com, Twitter.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");
        System.out.println("A-G / 0-6");

        // Repeat with each DotCom-object in the ArrayList.
        for(DotCom dotComToSet : dotComList){

            // Each location cell should be 3 cells large and stored in an ArrayList
            ArrayList<String> newLocation = helper.placeDotCom(3);

            // We use the randomized cells from the array above to set each object's locationCells
            dotComToSet.setLocationCells(newLocation);
        }
    }

    // Starts the game. Repeats while there are still DotCom's in the ArrayList. Gets user input and checks that input against each DotCom's location.
    public void startPlaying(){

        // Repeat as long as the DotCom list is NOT empty.
        while(!dotComList.isEmpty()){

            // Get user input
            String userGuess = helper.getUserInput("Enter your guess: ");

            // Checks if the users guess is a hit or a miss.
            checkUserGuess(userGuess);
        }

        // When the dotComList is empty, we jump out of the While-loop and the game is over.
        finishGame();
    }

    // Check the users guess to find out if there's a hit, miss or kill on any DotCom
    public void checkUserGuess(String userGuess){

        numOfGuesses++;
        String result = "Miss!";

        // Repeat with each DotCom-object in the ArrayList.
        for(DotCom dotComToTest : dotComList){

            // Check if the userGuess is a hit or a miss
            result = dotComToTest.checkYourself(userGuess);

            if(result.equals("Hit!")){
                break;      // Since it is a "Hit" we don't need to check the other objects.
            }

            // If it is a "Kill" we remove the object from the ArrayList
            if(result.equals("Kill!")){
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println("It was a " + result);
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
