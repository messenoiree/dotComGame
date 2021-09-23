import java.util.ArrayList;

public class DotCom {

    // The actual DotCom-class that makes the DotCom-objects.
    // DotCom's know their name, location and how to check a user guess for a match.

    private String name;                            // Each DotCom-object has its own name.
    private ArrayList<String> locationCells;        // Each DotCom-object has its own ArrayList of cell locations.

    // This setter method updates the DotCom's location. (Random location provided by the GameHelper's placeDotCom()-method).
    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    // Basic setter method.
    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput){

        String result = "Miss!";

        // If the user guess is one of the entries in the ArrayList, indexOf() will return the index of that entry.
        // If the user guess is not one of the entries in the ArrayList, indexOf() will return -1.
        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);        // We use ArrayList's remove()-method to delete an index of the ArrayList.

            if(locationCells.isEmpty()){        // We use ArrayList's isEmpty()-method to see if all the locations have been guessed.
                result = "Kill!";
                System.out.println("Ouch! You sunk " + name + " :  ( ");    // We tell the user when a DotCom has been sunk.
            }else{
                result = "Hit!";
            }

        }
        return result;      // We return "Miss!", "Hit!" or "Kill!".

    }



}
