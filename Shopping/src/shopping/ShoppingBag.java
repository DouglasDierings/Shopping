/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import curentstockDTO.StockManagementDTO;
import databaseDAO.DatabasestockDAO;
import java.util.ArrayList;
import productlist.*;

/**
 * A simple ShoppingBag
 *
 * Stores items in an ArrayList
 *
 * Possible to add items Also can "empty" the bag
 *
 * You should NOT need to amend this code at all!
 *
 *
 * @author Ken (Edit by Douglas Vinicius Dierings 2022322)
 */
public class ShoppingBag {

    private ArrayList<Electronic> items;//Create and arryList with the tipy Electronic
    StockManagementDTO stock = new StockManagementDTO();
    DatabasestockDAO stockDAO = new DatabasestockDAO();
    private final int maximumItems = 10;//Add a maximun item to buy
    private int quantityInTheBag = 0;//Stores the quantity in the bag
    private double totalToPay = 0;//Stores the total to be pay
    private int itemsQuantity;
    private int id;

    /**
     * Create a shopping bag by initializing the items to an empty arrayList
     */
    public ShoppingBag() {

        items = new ArrayList<Electronic>();
    }

    /**
     * Add an item to the shopping bag and the price of the item in the total to
     * be pay
     *
     * @param product the item that has been bought
     */
    public void buyItem(Electronic product) {

        stock.setIdItem(id);

        stockDAO.getStock(stock);

        stock.setQuantity(itemsQuantity);

        if (quantityInTheBag < maximumItems) {//Check if have space in the bag

            if (itemsQuantity <= stock.getCurrentStock()) {
                for (int i = 0; i < itemsQuantity; i++) {//Loop to add the quantity of items to the bag
                    this.items.add(product);//Add the selected item to the bag 
                    totalToPay += product.getPrice();
                    quantityInTheBag++;
                }

                stockDAO.getItemFromStock(stock);

            } else {
                System.out.println("Product sold out.");

            }
        }
    }

    //Methods
    /**
     * create a formatted String containing all the items in the ShoppingBag
     *
     * @return the formatted String
     */
    public String getBag() {//I change the name of the method to meke more sence with the function that it performs
        String itemList = "";
        int itemNumber = 1;
        for (Object item : this.items) {
            itemList += itemNumber + " - " + item.toString() + "\n";
            itemNumber++;
        }

        //this.items.clear(); I removed this because when I call the method in the middle of the code (main) to show the current items in the bag it was cleaning the bag
        return itemList;
    }

    /**
     * Remove an item from the bag at the specified index and discount from the
     * totalToPay the price of the product removed
     *
     * @param index the index of the item to remove
     */
    public void removeItem(int index) {
        stock.setIdItem(items.get(index - 1).getId());
        stockDAO.returnItemToStock(stock);
        totalToPay -= items.get(index - 1).getPrice();
        items.remove(index - 1);//The -1 is because the index of arrys starts at 0
        System.out.println("Product Removed.");

    }

    public void leaveShop() {
        stockDAO.closeConnection();
        items.clear();
    }

    //Getters and setters
    public int getBagSize() {
        int bagSize = this.items.size();
        return bagSize;
    }

    public int getMaximumItems() {
        return maximumItems;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public int getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(int itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
