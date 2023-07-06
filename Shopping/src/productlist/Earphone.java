package productlist;

/**
 * Create a Earphone
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class Earphone extends Electronic {//Extends the Electronic class so I can use the properties and methods from the class

    //Properties
    private boolean bluetooth;
    private String chargingMethod;
    private boolean noiseCancellation;
    private boolean playing;

    //Constructor
    public Earphone(double price, String brand, String color, int id, String chargingMethod, boolean noiseCancellation) {
        super(price, brand, color,id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.chargingMethod = chargingMethod;
        this.noiseCancellation = noiseCancellation;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override
    public String toString() {
        return "Earphone{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", charging method=" + chargingMethod + '}';
    }

    //Play music method
    public boolean playMusic() {
        //If the Bluetooth is on it plays the music otherwise not
        if (bluetooth) {
            this.playing = true;
        } else {
            this.playing = false;
            System.out.println("Turn on the bluetooth");
        }
        return playing;
    }

    //Connect device method
    public String conectDevice() {
        //If the Bluetooth is on it scan for new devices otherwise not and returns a String if it is connected or not
        if (bluetooth) {
            System.out.println("Scanning for new devices.");
            return "Device conected.";
        } else {
            return "Turn on the bluetooth.";
        }
    }

    //Enable noise cancellation
    public void enableNoiseCancellation() {
        this.noiseCancellation = true;
    }
    
    //Disable noise cancellation
    public void disableNoiseCancellation() {
        this.noiseCancellation = false;
    }

    //Getters and setters
    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isNoiseCancellation() {
        return noiseCancellation;
    }

    public void setNoiseCancellation(boolean noiseCancellation) {
        this.noiseCancellation = noiseCancellation;
    }

    public String getChargingMethod() {
        return chargingMethod;
    }

    public void setChargingMethod(String chargingMethod) {
        this.chargingMethod = chargingMethod;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

}
