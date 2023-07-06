package productlist;

/**
 * Create a Smartphone
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class Smartphone extends CellPhone {//Extends the CellPhone class so I can use the properties and methods from the class

    //Properties
    private double screenSize;
    private int memoryRAM;
    private boolean bluetooth;

    //Constructor
    public Smartphone(double price, String brand, String color,int id, boolean camera, int internalMemory, int memoryRAM, double screenSize) {
        super(price, brand, color, id, camera, internalMemory);//It refers to the super class to set the properties, in this case to the Eletronic and CellPhone classes
        this.memoryRAM = memoryRAM;
        this.screenSize = screenSize;
        this.bluetooth = false;
        super.setStatusOnOff(false);//Smartphone is set off as default (using the super class properties
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override//Override the method in the super class
    public String toString() {
        return "Smartphone{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", internal memory=" + internalMemory + ", screen size=" + screenSize + ", memory RAM=" + memoryRAM + '}';
    }

    //Watch a video
    public String watchVideo() {
        return "Playing YouTube!";
    }

    //Connect to a device
    public String conectDevice() {
        if (bluetooth) {
            return "Device conected.";
        } else {
            return "Turn on the bluetooth.";
        }
    }

    @Override//Override the method in the super class
    //A method that returns a String sain that the phone will be reset
    public String resetPhone() {
        return "Your phone will be reseted. All your accounts will be log off.";
    }

    @Override//Override the method in the super class
    //A method that charges the battery until 100%
    public void recharge() {
        do {
            super.batteryStatus += 2;//fast charging
        } while (super.batteryStatus < 100);
    }

    //Getters and setters
    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getMemoryRAM() {
        return memoryRAM;
    }

    public void setMemoryRAM(int memoryRAM) {
        this.memoryRAM = memoryRAM;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

}
