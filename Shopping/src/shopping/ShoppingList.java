package shopping;

import java.util.ArrayList;
import productlist.*;//Import all the items in the productlist package

/**
 * This class stores all the items available in the store. I create this class
 * separate so when I want to add a needed product I just need to make changes
 * in this code, and in the main code (shopping) no changes need to be made
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class ShoppingList {

    private int selectedNumber;//Stores the user input
    private ArrayList<Electronic> itemsList = new ArrayList<Electronic>();//Create an ArrayList 

    //Shopping list objects
    CellPhone phone = new CellPhone(99, "Nokia", "Red",1, false, 8);
    Smartphone smartphone = new Smartphone(799, "Apple", "White",2, true, 128, 12, 6.8);
    Wristwatch wristwatch = new Wristwatch(119, "OLEVS", "Gray",3, true, "Analogic");
    Smartwatch smartwatch = new Smartwatch(249.49, "Amazon", "Black",4, true, "Digital", 40);
    Earphone earphone = new Earphone(119.99, "Sansung", "Dark Blue",5, "Wireless", true);
    Speaker speaker = new Speaker(125, "JBL", "Black",6, 35);
    DigitalCamera digitalCamera = new DigitalCamera(89, "Canon", "Blue",7, 48, 64);
    CellPhone phone2 = new CellPhone(125, "Sansung", "Black",8, 16);
    Electronic item;//Store the object to be returned in the method "selectItem"

    //Add items to the list
    public ShoppingList() {
        itemsList.add(phone);
        itemsList.add(smartphone);
        itemsList.add(wristwatch);
        itemsList.add(smartwatch);
        itemsList.add(earphone);
        itemsList.add(speaker);
        itemsList.add(digitalCamera);
        itemsList.add(phone2);
    }

    //Create one option for each item in the list, return the object so the program can get all the information of the product and methods
    public Electronic selectItem() {
        switch (selectedNumber) {
            case 1:
                item = phone;
                break;
            case 2:
                item = smartphone;
                break;
            case 3:
                item = wristwatch;
                break;
            case 4:
                item = smartwatch;
                break;
            case 5:
                item = earphone;
                break;
            case 6:
                item = speaker;
                break;
            case 7:
                item = digitalCamera;
                break;
            case 8:
                item = phone2;
                break;
        }
        return item;
    }

    /**
     * Returns a formatted string containing the list of items avalieble in the
     * store to the user to choose
     *
     * @return the formatted String
     */
    public String getItemsList() {
        String item = "";//Create a empty String
        int itemNumber = 1;
        for (Object product : this.itemsList) {
            item += itemNumber + " - " + product.toString() + "\n";
            itemNumber++;
        }
        return item;
    }

    //Getters and setters
    
    //Returns the size of the bag list
    public int getListSize() {
        int listSize = this.itemsList.size();
        return listSize;
    }
    //Returns the selected number by the user

    public int getSelectedNumber() {
        return selectedNumber;
    }

    //Sets the selected number
    public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

}
