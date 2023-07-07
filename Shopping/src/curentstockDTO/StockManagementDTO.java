/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curentstockDTO;

/**
 * Data Transfer Object (DTO) for representing quantity stock information.
 */
public class StockManagementDTO {

    private int currentStock; // Current stock quantity
    private int quantity; // Quantity to be updated
    private int idItem; // Item ID

    /**
     * Get the current stock quantity.
     *
     * @return The current stock quantity.
     */
    public int getCurrentStock() {
        return currentStock;
    }

    /**
     * Set the current stock quantity.
     *
     * @param currentStock The current stock quantity to set.
     */
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    /**
     * Get the quantity to be updated.
     *
     * @return The quantity to be updated.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity to be updated.
     *
     * @param quantity The quantity to be updated.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the item ID.
     *
     * @return The item ID.
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Set the item ID.
     *
     * @param idItem The item ID to set.
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
}
