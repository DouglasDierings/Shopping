package productlist;

/**
 * Create a Digital Camera
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public class DigitalCamera extends Electronic {//Extends the Electronic class so I can use the properties and methods from the class

    //Properties
    private int megaPixels;
    private int internalMemory;
    private int resolution;
    private boolean record;

    //Constructor
    public DigitalCamera(double price, String brand, String color,int id, int megaPixels, int internalMemory) {
        super(price, brand, color,id);//It refers to the super class to set the properties, in this case to the Eletronic class
        this.megaPixels = megaPixels;
        this.internalMemory = internalMemory;
    }

    //Methods
    //The method toString returns a String with the specifications of the product
    @Override
    public String toString() {
        return "Digital Camera{" + "price=" + price + ", brand=" + brand + ", color=" + color + ", megapixels=" + megaPixels + ", internal memory=" + internalMemory + '}';
    }

    //Take a picture
    public String takePicture() {
        return "Picture saved.";
    }

    //Start recording video
    public String starRecordVideo(int resolution) {
        this.record = true;
        return "Recording in the resolution: " + resolution;
    }

    //Stop recording video
    public void stopRecordVideo() {
        this.record = false;
    }

    //Getters and setters
    public int getMegaPixels() {
        return megaPixels;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public int getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

}
