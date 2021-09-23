public class Main {

    public static void main(String[] args) {

        DotComBust game = new DotComBust();     // We create the Game-object.

        game.setUpGame();       // We tell the Game-object to set up the game.
        game.startPlaying();    // We tell the Game-object to start the main game play loop (keeps asking for user input and checking the guess).

    }

}
