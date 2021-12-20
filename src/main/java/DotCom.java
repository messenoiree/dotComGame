import java.util.ArrayList;

public class DotCom {

    // Each DotCom-object has its own name and cell locations
    private String name;
    private ArrayList<String> locationCells;

    // Updates the DotCom's location with 3 random cells
    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    // Basic setter for the name-field
    public void setName(String name) {
        this.name = name;
    }

    // Checks weather the user guess is a "Hit", "Miss" or "Kill".
    public String checkYourself(String userInput){

        String result = "Miss!";

        // Returns the index of the user entry if it exists in the array, otherwise returns -1.
        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result = "Kill!";
                System.out.println("Ouch! You sunk " + name + " :  ( ");
            }else{
                result = "Hit!";
            }
        }
        return result;
    }
}
