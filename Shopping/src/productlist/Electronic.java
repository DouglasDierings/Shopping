package productlist;

/**
 * The class Electronic is declared as abstract, which means it cannot be
 * instantiated directly but I can used as a base class for other classes that I
 * created for the products. All the products in my shop have price, brand and
 * color.
 *
 * @author Douglas Vinicius Dierings 2022322
 */
public abstract class Electronic {

    //Properties
    //The proprieties are defined as protected because their subclass will use this properties
    protected double price;
    protected String brand;
    protected String color;
    protected int id;

    //Constructor
    //This constructor is for the subclasses set initial values for its properties
    public Electronic(double price, String brand, String color, int id) {
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.id = id;
    }

    //Getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
