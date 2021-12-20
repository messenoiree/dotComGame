import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    // This is the Helper Class for the game.
    // Besides the getUserInput()-method (that prompts the user and reads input from the command-line),
    // the helper's Big Service is to create the cell locations for the DotCom's.

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    // Gets and checks the user input
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine.toLowerCase();
    }

    // Creates randomly placed cell locations for DotCom's
    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int)(Math.random() * gridSize);
            //System.out.print(" try " + location);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    //System.out.print(" used " + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
        //System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            //System.out.print(" coord "+x+" = " + alphaCells.get(x-1));
        }

        return alphaCells;
    }


}
