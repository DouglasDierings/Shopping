package productlist;

/**
 * Create a Wristwatch
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class Wristwatch extends Electronic {//Extends the Electronic class so I can use the properties and methods from the class

    //Properties
    //The proprieties are defined as protected because their subclass will use this properties
    protected boolean waterApproval;
    protected String displayType;
    protected boolean status;

    //Constructor
    public Wristwatch(double price, String brand, String color,int id, boolean waterApproval, String displayType) {
        super(price, brand, color,id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.waterApproval = waterApproval;
        this.displayType = displayType;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override
    public String toString() {
        return "Wristwatch{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", water approval=" + waterApproval + ", display type=" + displayType + '}';
    }

    // Recharge the wristwatch (in this case insert a new batterie
    public void recharge() {
        System.out.println("Inserting new batteries.");
    }

    //Start the clock
    public void startClock() {
        this.status = true;
    }

    //Stop the clock
    public void stopClock() {
        this.status = false;
    }

    //Getters and setters
    public boolean isWaterApproval() {
        return waterApproval;
    }

    public void setWaterApproval(boolean waterApproval) {
        this.waterApproval = waterApproval;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
