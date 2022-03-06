package reviews.data;

public class Hairdresser extends Business{

    Boolean type;

    public Hairdresser(String name, String city, Boolean type){
        super(name, city);
        this.type=type;
    }

    public Boolean getType() {
        return type;
    }

    @Override
    public String toString() {
        if(type)
            return super.toString() + " - unisex" + ". Review Average: " + reviewAverage();
        else
            return super.toString() + " - not unisex" + ". Review Average: " + reviewAverage();
    }
}
