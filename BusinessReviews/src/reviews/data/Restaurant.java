package reviews.data;

public class Restaurant extends Business {

    String type;

    public Restaurant(String name, String city, String type){
        super(name, city);
        this.type=type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + type + ". Review Average: " + reviewAverage();
    }
}
