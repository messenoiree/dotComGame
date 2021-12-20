public class Main {

    public static void main(String[] args) {

        DotComBust game = new DotComBust();     // Create the Game-object.

        game.setUpGame();       // Set up the game.
        game.startPlaying();    // Start the main gameplay loop (keeps asking for user input and checking the guess).
    }

}
