package productlist;

/**
 * Create a Smartwatch
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class Smartwatch extends Wristwatch {//Extends the Wristwatch class so I can use the properties and methods from the class

    //Properties
    private int screenSizeMM;
    private boolean connectionStatus;
    private double alarm;
    private int batteryStatus;

    //Constructor
    public Smartwatch(double price, String brand, String color,int id, boolean waterApproval, String displayType, int screenSizeMM) {
        super(price, brand, color,id, waterApproval, displayType);//It refers to the super class to set the properties, in this case to the Eletronic and Wristwatch classes
        this.screenSizeMM = screenSizeMM;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override//Override the method in the super class
    public String toString() {
        return "Smartwatch{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", water approval=" + waterApproval + ", screen size(MM)=" + screenSizeMM + '}';

    }

    //Show notification method
    public void showNotification() {
        System.out.println("Notification display.");
    }

    @Override//Override the method in the super class
    //A method that charges the battery until 100%
    public void recharge() {
        do {
            this.batteryStatus++;
        } while (this.batteryStatus < 100);
    }

    //Connect watch method
    public void connectWatch() {
        this.connectionStatus = true;
    }

    //Set alarm method
    public String alarm(double alarmHour) {
        this.alarm = alarmHour;
        return "Alarm set up for " + this.alarm;
    }

    //Getters and setters
    public int getScreenSizeMM() {
        return screenSizeMM;
    }

    public void setScreenSizeMM(int screenSizeMM) {
        this.screenSizeMM = screenSizeMM;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public double getAlarm() {
        return alarm;
    }

    public void setAlarm(double alarm) {
        this.alarm = alarm;
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

}
