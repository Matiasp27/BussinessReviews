package reviews.main;

import reviews.data.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[]  args) throws InterruptedException {
        User aux;
        Scanner sc = new Scanner(System.in);
        String login, pass;
        Management data = new Management();
        data.initialize();

        do {
            System.out.print("Usuario: ");
            login = sc.nextLine();
            System.out.print("Contraseña: ");
            pass = sc.nextLine();
        }while(data.login(login, pass) == null);
        aux=data.getUser(login);

        Menu(sc, data, aux);
    }

    public static void Menu(Scanner sc, Management data, User user){
        int opt;
        System.out.println("Menú.");
        do {
            System.out.println("""
                    1.My reviews
                    2.Business list
                    3.Top rated business
                    4.Edit my review
                    5.Quit""");
            System.out.print("Introduce tu opción: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1 -> MyReviews(data, user);
                case 2 -> BusiList(data);
                case 3 -> TopRated(data, sc);
                case 4 -> Edit(data, user);
            }
        }while(opt!=5);
    }
    static void MyReviews(Management data, User user){
        for(int i=0; i<data.getBusiness().length; i++){
            for(int j=0; j<data.getBusiness()[i].getCantRev(); j++) {
                if (data.getBusiness()[i].getReviews()[j].getUser()==user){
                    System.out.println(data.getBusiness()[i].toString() + ":");
                    System.out.println(data.getBusiness()[i].getReviews()[j].toString());
                }
            }
        }
    }

    static void BusiList(Management data){
        Arrays.sort(data.getBusiness());

        for(Business b : data.getBusiness()){
            System.out.println(b.toString());
        }
    }

    static void TopRated(Management data, Scanner sc){
        int opt;
        System.out.println("""
                Introduce el tipo de negocio:
                1.Restaurante
                2.Peluquería
                3.Garage""");
        opt=sc.nextInt();
        data.sortAvg();
        switch (opt){
            case 1:
                for(Business b: data.getBusiness()) {
                    if (b instanceof Restaurant)
                        System.out.println(b);
                }
                break;
            case 2:
                for(Business b : data.getBusiness()) {
                    if (b instanceof Hairdresser)
                        System.out.println(b);
                }
                break;
            case 3:
                for(Business b: data.getBusiness()) {
                    if (b instanceof Garage)
                        System.out.println(b);
                }
                break;
            default:
                System.out.println("Opción incorrecta.");
                break;
        }

    }

    static void Edit(Management data, User user){
        int i=0, j=0, rate;
        Scanner sc = new Scanner(System.in);
        String opt;
        boolean exists=false;
        System.out.print("Introduce el nombre del negocio: ");
        opt = sc.nextLine();
        while(i<data.getBusiness().length && !exists) {
            j=0;
            if (Objects.equals(data.getBusiness()[i].getName(), opt)) {
                while(j < data.getBusiness()[i].getCantRev() && !exists) {
                    if (data.getBusiness()[i].getReviews()[j].getUser() == user)
                        exists = true;
                    else
                        j++;
                }
            }
            else
                i++;
        }
        if(exists){
            System.out.print("Introduce tu nueva review: ");
            opt=sc.nextLine();
            do {
                System.out.print("Introduce la puntuación(0 a 5): ");
                rate = sc.nextInt();
            }while(rate<0 || rate>5);

            data.getBusiness()[i].getReviews()[j] = new Reviews(user, opt, rate);
        }
        else
            System.out.println("No tienes ninguna review en ese negocio.");
    }
}
