import java.util.Scanner;
public class Bankomat{
    private static Scanner in;
    private static float Stan = 0;
    private static float kontoOszczednościowe=0;
    private static float przelew=0;
    private static int kolejnatransakcja;
    public static void main(String args[]){
        in = new Scanner(System.in);
        Transakcja();
    }
    private static void Transakcja(){
        int wybór;
        System.out.println("Proszę wybrać opcję");
        System.out.println("1.Wpłata");
        System.out.println("2.Wyplata");
        System.out.println("3.Stan konta");
        System.out.println("4.Przelew na konto Oszczędnościowe");
        System.out.println("5.Konto Oszczędnościowe");
        wybór = in.nextInt();
        switch(wybór){
            case 1:
                float depozyt;
                System.out.println("Podaj kwotę jaką chcesz wpłacić ");
                depozyt = in.nextFloat();
                if(depozyt<0){
                    System.out.println("Podaj kwote większa od zera!!");
                    System.out.println("Podaj kwotę jaką chcesz wpłacić ");
                    depozyt = in.nextFloat();
                    Stan = depozyt + Stan;
                    kolejnatransakcja();
                }
                else {

                    Stan = depozyt + Stan;
                    System.out.println("Wpłaciłes teraz " + depozyt + " stan konta to " + Stan + "\n");
                    kolejnatransakcja();
                }
                break;
            case 2:
                float kwota;
                System.out.println("Proszę podać ilość gotówki do wypłaty ");
                kwota = in.nextFloat();
                if(kwota > Stan || kwota == 0){
                    System.out.println("Nie masz takiej sumy na koncie\n");
                    kolejnatransakcja();
                } else {
                    Stan = Stan - kwota;
                    System.out.println("Wypłaciłeś "+kwota+" twój stan konta wynosi teraz "+Stan+"\n");
                    kolejnatransakcja();
                }
                break;
            case 3:
                System.out.println("Twój stan konta wynosi "+Stan+"\n");
                kolejnatransakcja();
                break;
            default:
                System.out.println("Nie właściwa opcja\n");
                kolejnatransakcja();
                break;
            case 4:

                System.out.println("Jaką kwotę chcesz przelać? ");
                przelew = in.nextFloat();
                if(przelew>Stan){
                    System.out.println("Nie ma takich funduszy na koncie podaj inna kwote");
                    przelew = in.nextFloat();
                    Stan=Stan-przelew;
                    kolejnatransakcja();
                }else{
                    Stan=Stan-przelew;
                    System.out.println("Stan konta po przelewie wynosi "+Stan);
                    kolejnatransakcja();
                }
                break;
            case 5:
                kontoOszczednościowe=przelew;
                System.out.println("Stan konta oszczędnościowego wynosi "+kontoOszczednościowe);
                kolejnatransakcja();
                break;
        }



    }
    private static void kolejnatransakcja(){
        System.out.println("Czy chcesz przeprowadzić inną transakcję ?\n Naciśnij 1 aby wybrać inną\n 2 żeby wyjść z bankomatu");
        kolejnatransakcja = in.nextInt();
        if(kolejnatransakcja == 1){
            Transakcja();
        } else if(kolejnatransakcja == 2){

        } else {
            System.out.println("Nie właściwy wybór\n");
            kolejnatransakcja();
        }
    }
}

