package shopping;

import ioutils.IOUtils;

/**
 * This is the my "store". If I add a new item to my store I do not need to make
 * any changes here. The user can add, remove and see the bag. It use MySQL to
 * manage the stock control.
 *
 * @author Douglas Vinicius Dierings
 */
public class Shopping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Initialize necessary objects and variables
        IOUtils input = new IOUtils();
        ShoppingList shoppingList = new ShoppingList();
        ShoppingBag myBag = new ShoppingBag();
        int selectedQuantity;//Stores the quantity selected
        //Determine the option number for each extra option avaliable in the store. This is use so every time I add a new item in the list I do not need to make any changes
        int seeBagOption = shoppingList.getListSize() + 1;
        int removeItemOption = shoppingList.getListSize() + 2;
        int exitShopOption = shoppingList.getListSize() + 3;

        //Display welcome message
        System.out.println("=====> Welcome to Dierings Store <=====");
        System.out.println(">> You can buy a maximum of " + myBag.getMaximumItems() + " items <<");
        //Start the shopping process
        do {
            System.out.println("Products list:\n"
                    + shoppingList.getItemsList()//Prints the products available in the shop
                    + "---------------------------------------\n"
                    + seeBagOption + " - See my bag\n" + removeItemOption + " - Remove item from the bag\n" + exitShopOption + " - Leave the shop\n"//Prints the extra options in the shop
                    + "---------------------------------------");
            shoppingList.setSelectedNumber(input.getUserInt("Please select the product you want to buy by enter the respective number or " + removeItemOption + " to remove one item from the bag or " + exitShopOption + " to exit the shop:", 1, exitShopOption));//prints a messege with instruction to the user and get the user input            
            if (shoppingList.getSelectedNumber() == seeBagOption) {//Check if the user selected the option to see the bag
                if (myBag.getBagSize() == 0) {//Check if the bag is empty
                    System.out.println("Your bag is empty!");
                } else {
                    System.out.printf("Products in your bag:\n" + myBag.getBag() + "Total to pay is %.2f EUR\n", myBag.getTotalToPay());//Display the items in the shopping bag and the amount to be pay so far
                    System.out.println("======================================");
                }
            } else if (shoppingList.getSelectedNumber() == removeItemOption) {//Check if the user selected the option to remove one item
                System.out.printf("Products in your bag:\n" + myBag.getBag() + "Total to pay is %.2f EUR\n", myBag.getTotalToPay());//Display the items in the shopping bag and the amount to be pay so far
                shoppingList.setSelectedNumber(input.getUserInt("Enter the number of the respective item you want to remove or " + (myBag.getBagSize() + 1) + " to cancel the operation ", 1, myBag.getBagSize() + 1));//Get the user input, witch item should be removing
                if (shoppingList.getSelectedNumber() == myBag.getBagSize() + 1) {//Chec if the user want to cancel the operation
                    continue;//Continues the program
                } else {
                    myBag.removeItem(shoppingList.getSelectedNumber());//Call the method to remove the item selected
                }
            } else if (shoppingList.getSelectedNumber() <= shoppingList.getListSize()) {//If the user input is less than the size of the shooping list. It means that he selected one item and not the others extra options
                myBag.setId(shoppingList.getSelectedNumber());
                selectedQuantity = input.getUserInt("Enter the quantity: ", 1, myBag.getMaximumItems() - myBag.getBagSize());//Get the quantity from the user
                myBag.setItemsQuantity(selectedQuantity);//Set the quantity the user wants to buy in the class myBag
                myBag.buyItem(shoppingList.selectItem());//Add the item to the bag (array and update the stock SQL)
                System.out.println("Item added to the bag!");//Confirms that the item was add to the bag
                System.out.println("---------------------------------------");
            }
        } while ((shoppingList.getSelectedNumber() != exitShopOption) && (myBag.getBagSize() < myBag.getMaximumItems()));//A loop that keep going until the user select the option to leave the shop or the bag is full
        System.out.println("---------------------------------------");
        if (myBag.getBagSize() == 0) {//Check if the bag is empty
            System.out.println("Your bag is empty!\nThank you for visiting!");
        } else {
            if (myBag.getBagSize() >= myBag.getMaximumItems()) {//Check if the bag is full and shows him a message
                System.out.println("Your bag is full. Leaving the shop.");
                System.out.println("======================================");
            }
            System.out.println("This is all itens in your bag:\n" + myBag.getBag());//Display the items in the shopping bag
            System.out.printf("Total to pay is %.2f EUR", myBag.getTotalToPay());//Display the total amount to pay
            myBag.leaveShop();//Clean the bag
            System.out.println("\nThank you for shopping wits us!\nSee you soon!");//Bye message
        }
    }

}
