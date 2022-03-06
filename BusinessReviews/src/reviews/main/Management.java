package reviews.main;

import reviews.data.*;

public class Management {

    final int usLng = 10; //Máximo número de usuarios
    final int bsLng = 6; //Máximo número de negocios
    User[] users = new User[usLng];
    Business[] busi = new Business[bsLng];

    public void initialize(){
        String name;
        String pass;

        for(int i=0; i<usLng; i++){
            name="name"+i;
            pass="pass"+i;
            users[i] = new User(name, pass);
        }
        busi[0]=new Restaurant("a","a", "Italiano");
        busi[1]=new Restaurant("b","b", "Chino");
        busi[2]=new Hairdresser("c","c", true);
        busi[3]=new Hairdresser("d","d", false);
        busi[4]=new Garage("e","e", 30);
        busi[5]=new Garage("f","f", 20);

        busi[0].setReview(new Reviews (users[0], "Review0", 0));
        busi[0].setReview(new Reviews (users[1], "Review1", 1));

        busi[1].setReview(new Reviews (users[2], "Review2", 2));
        busi[1].setReview(new Reviews (users[3], "Review3", 3));

        busi[2].setReview(new Reviews (users[4], "Review4", 4));
        busi[2].setReview(new Reviews (users[5], "Review5", 5));

        busi[3].setReview(new Reviews (users[6], "Review6", 1));
        busi[3].setReview(new Reviews (users[7], "Review7", 2));

        busi[4].setReview(new Reviews (users[8], "Review8", 3));
        busi[4].setReview(new Reviews (users[9], "Review9", 4));

        busi[5].setReview(new Reviews (users[0], "Review10", 5));
        busi[5].setReview(new Reviews (users[1], "Review11", 0));
    }

    public User login(String log, String pass){
        int i=0;
        while(i<users.length){
            if(log.equals(users[i].getLogin())&&pass.equals(users[i].getPassword()))
                return users[i];
            i++;
        }
        return null;
    }

    public void sortAvg(){
        for (int i = 0; i < getBusiness().length; i++)
        {
            for (int j = 0; j < getBusiness().length - i - 1; j++)
            {
                if (getBusiness()[j].reviewAverage() <
                        getBusiness()[j+1].reviewAverage())
                {
                    Business auxiliar = getBusiness()[j];
                    getBusiness()[j] = getBusiness()[j+1];
                    getBusiness()[j+1] = auxiliar;
                }
            }
        }
    }

    public User getUser(String log){
        for (User user : users) {
            if (log.equals(user.getLogin()))
                return user;
        }
        return null;
    }

    public Business[] getBusiness() {
        return busi;
    }
}
