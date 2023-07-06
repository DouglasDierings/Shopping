package productlist;

/**
 * Create a Cellphone
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class CellPhone extends Electronic {//Extends the Electronic class so I can use the properties and methods from the class

    //Properties
    //The proprieties are defined as protected because their subclass will use this properties
    protected boolean camera;
    protected int internalMemory;
    protected boolean statusOnOff;
    protected int batteryStatus;

    //Contructor
    public CellPhone(double price, String brand, String color,int id, boolean camera, int internalMemory) {
        super(price, brand, color, id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.camera = camera;
        this.internalMemory = internalMemory;
        this.batteryStatus = 100;
        this.statusOnOff = false;//CellPhone is set off as default
    }

    //Overloaded Constructor (it uses different quantity parameters to overload the constructor)
    public CellPhone(double price, String brand, String color,int id, int internalMemory) {
        super(price, brand, color, id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.internalMemory = internalMemory;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override
    public String toString() {
        return "Cellphone{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", camera=" + camera + ", internal memory=" + internalMemory + '}';
    }

    //A method that returns a String if someone is calling
    public String ringing() {
        return "Someone is calling.";
    }

    //A method that returns a String sain that the phone will be reset
    public String resetPhone() {
        return "Your phone will be reseted.";
    }

    //A method that charges the battery until 100%
    public void recharge() {
        do {
            this.batteryStatus++;
        } while (this.batteryStatus < 100);
    }

    //Getters and setters
    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public int getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public boolean isStatusOnOff() {
        return statusOnOff;
    }

    public void setStatusOnOff(boolean statusOnOff) {
        this.statusOnOff = statusOnOff;
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

}
