package productlist;

/**
 * Create a speaker
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class Speaker extends Electronic {//Extends the Electronic class so I can use the properties and methods from the class

    //Properties
    private boolean bluetooth;
    private int sizeCM;
    private boolean musicStatus;
    private int volume;

    //Constructor
    public Speaker(double price, String brand, String color,int id, int sizeCM) {
        super(price, brand, color,id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.sizeCM = sizeCM;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override
    public String toString() {
        return "Speaker{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", size(CM)=" + sizeCM + '}';
    }

    //Connect the speaker to a device
    public void conectDevice() {
        if (bluetooth) {
            System.out.println("Device conected.");
        } else {
            System.out.println("Turn on the bluetooth.");
        }
    }

    //Increase the volume
    public void increaseVolume() {
        this.volume++;
    }

    //Decrease the volume
    public void decreaseVolume() {
        this.volume--;
    }

    //Getters and setters
    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getSizeCM() {
        return sizeCM;
    }

    public void setSizeCM(int sizeCM) {
        this.sizeCM = sizeCM;
    }

    public boolean isMusicStatus() {
        return musicStatus;
    }

    public void setMusicStatus(boolean musicStatus) {
        this.musicStatus = musicStatus;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
