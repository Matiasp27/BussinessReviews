package reviews.data;

public class Garage extends Business{

    float price;

    public Garage(String name, String city, float price){
        super(name, city);
        this.price=price;
    }

    public float getType() {
        return price;
    }

    @Override
    public String toString() {
            return super.toString() + " - " + price + "eur/h" + ". Review Average: " + reviewAverage();
    }
}
