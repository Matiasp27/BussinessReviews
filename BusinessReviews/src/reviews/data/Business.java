package reviews.data;

public abstract class Business implements Comparable<Business> {
    protected String name;
    protected String city;
    protected Reviews[] reviews;
    protected int cantRev;

    public Business(String name, String city){
        this.name=name;
        this.city=city;
        this.cantRev=0;
        this.reviews = new Reviews[50];
    }

    public float reviewAverage(){
        float suma=0;
        for (int i=0; i<cantRev; i++) {
            suma += reviews[i].getRating();
        }
        return suma/cantRev;
    }

    @Override
    public int compareTo(Business otro) {
        return name.compareTo(otro.getName());
    }

    public String getName() {

        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCantRev() {
        return cantRev;
    }

    public Reviews[] getReviews() {
        return reviews;
    }

    public void setReview(Reviews review){
        boolean exists=false;
        int i=0;
        while(i<cantRev && !exists) {
            if(this.reviews[i].getUser()==review.getUser())
                exists=true;
            else
                i++;
        }
        if(!exists && cantRev<reviews.length) {
            this.reviews[cantRev] = review;
            cantRev++;
        }
        else
            System.out.println("Error añadiendo la valoración.");
    }

    @Override
    public String toString() {
        return name + " (" + city + ")";
    }
}
