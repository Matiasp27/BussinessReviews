package reviews.data;

public class Reviews {
    User user;
    String comment;
    int rating;

    public Reviews(User user, String comment, int rating){
        this.user=user;
        this.comment=comment;
        if(rating>=0&&rating<=5)
            this.rating=rating;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return user.getLogin() + "\n" +  comment + '\n' + rating + "*";
    }
}
