
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        int menuValg;

        do {
            System.out.println("Velkommen Superhero universet!\n1. Opret superhelt\n2. Vis Superhelte liste\n9. Afslut program");
            menuValg = scanner.nextInt();
            scanner.nextLine();

            if (menuValg == 1) {
                System.out.println("indtast navnet på din superhelt:");
                String SuperHelteNavn = scanner.nextLine();
                System.out.println("indtast det rigtige navn på " + SuperHelteNavn + ":");
                String SuperHelterigtigeNavn = scanner.nextLine();
                // skal have det her til at virke med boolean
                System.out.println("indtast om din superhelt er et menneske (true/false):");
                boolean SuperHeltMenneske = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("indtast hvilke superkrafter " + SuperHelteNavn + " har:");
                String SuperHelteKrafter = scanner.nextLine();
                System.out.println("indtast hvilket år din superhelte opstod:");
                int SuperHelteAlder = scanner.nextInt();
                System.out.println("indtast hvilke styrke din superhelt har (0-100):");
                int SuperhelteStyrke = scanner.nextInt();

                System.out.println("Din Superhelt!\nSuperhelte Navn: " + SuperHelteNavn + "\nRigtige navn: " + SuperHelterigtigeNavn + "\nmenneske: " + SuperHeltMenneske + "\nKrafter: " + SuperHelteKrafter + "\nOpstandelse: " + SuperHelteAlder + "\nStyrke: " + SuperhelteStyrke);


            } else if (menuValg == 9) {
                System.out.println("program afsluttes");
            } else if (menuValg ==2){
                System.out.println(database.showListSuperheroes());
            }else {
                System.out.println("ugyldigt input");
            }
        }while(menuValg== 1 || menuValg == 2);
    }
}
