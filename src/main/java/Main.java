
import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til universet med dine superhelte!");
        System.out.println("indtast navnet på din superhelt:");
        String SuperHelteNavn = scanner.nextLine();

        System.out.println("indtast det rigtige navn på "+ SuperHelteNavn+":");
        String SuperHelterigtigeNavn = scanner.nextLine();

        // skal have det her til at virke med boolean
        System.out.println("indtast om din superhelt er et menneske (true/false):");
        String SuperHeltMenneske = scanner.nextLine();


        System.out.println("indtast hvilke superkrafter "+ SuperHelteNavn + " har:");
        String SuperHelteKrafter = scanner.nextLine();

        System.out.println("indtast hvilket år din superhelte opstod:");
        int SuperHelteAlder = scanner.nextInt();

        System.out.println("indtast hvilke styrke din superhelt har:");
        int SuperhelteStyrke = scanner.nextInt();



        System.out.println("Din Superhelt!\nSuperhelte Navn: "+SuperHelteNavn+"\nRigtige navn: "+ SuperHelterigtigeNavn+"\nmenneske: "+SuperHeltMenneske+"\nKrafter: "+SuperHelteKrafter+"\nOpstandelse: "+SuperHelteAlder+"\nStyrke: "+SuperhelteStyrke);

    }
}
