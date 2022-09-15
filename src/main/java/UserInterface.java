import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Database database = new Database();
    int menuValg;

    public void menu() {
        System.out.println("\nVelkommen Superhero universet!\n1. Opret superhelt\n2. Vis Superhelte liste\n3. Søg efter superhelt\n9. Afslut program");
        menuValg = scanner.nextInt();
        scanner.nextLine();
    }

    public void createSuperhero() {
        System.out.println("indtast navnet på din superhelt:");
        String heroName = scanner.nextLine();
        System.out.println("indtast det rigtige navn på " + heroName + ":");
        String heroRealName = scanner.nextLine();
        System.out.println("indtast om din superhelt er et menneske (j/n):");
        char SuperHeltMenneske = scanner.next().charAt(0);
        boolean isHuman = false;
        if (SuperHeltMenneske == 'j') {
            isHuman = true;
        } else if (SuperHeltMenneske == 'n') {
            isHuman = false;
        }
        scanner.nextLine();

        System.out.println("indtast hvilke superkrafter " + heroName + " har:");
        String HeroPowers = scanner.nextLine();
        System.out.println("indtast hvilket år din superhelte opstod:");
        int heroCreation = scanner.nextInt();
        System.out.println("indtast hvilke styrke din superhelt har (0-100):");
        int heroPowerLevel = scanner.nextInt();
        database.createSuperHero(heroName, heroRealName, isHuman, HeroPowers, heroCreation, heroPowerLevel);

        System.out.println("Din Superhelt!\nSuperhelte Navn: " + heroName + "\nRigtige navn: " + heroRealName + "\nmenneske: " + SuperHeltMenneske + "\nKrafter: " + HeroPowers + "\nOpstandelse: " + heroCreation + "\nStyrke: " + heroPowerLevel);

    }

    public void startProgram() {
        menu();

        if (menuValg == 1) {
            createSuperhero();
            startProgram();
        }
        else if (menuValg == 2) {
            System.out.println("Liste af superhelte:");
            for (Superhero superheroList : database.getSuperheroesList()) {
                System.out.println("----------------\n"
                        + "Superhelte navn: " + superheroList.getHeroName() + "\n"
                        + "Superkraft: " + superheroList.getHeroPowers() + "\n"
                        + "Virkelige navn: " + superheroList.getHeroRealName() + "\n"
                        + "Oprindelsesår: " + superheroList.getHeroCreation() + "\n"
                        + "Er menneske: " + superheroList.getHuman() + "\n"
                        + "Styrke: " + superheroList.getHeroPowerLevel());

            }
            startProgram();
        }
        else if (menuValg == 3) {
            System.out.println("----------------\nIndtast søgeord: ");
            String searchTerm = scanner.nextLine();
            Superhero superheroList = database.searchSuperhero(searchTerm);

            if (superheroList == null) {
                System.out.println("superhelt ikke fundet");
            } else {
                System.out.println("----------------\n"
                        + "Superhelte navn: " + superheroList.getHeroName() + "\n"
                        + "Superkraft: " + superheroList.getHeroPowers() + "\n"
                        + "Virkelige navn: " + superheroList.getHeroRealName() + "\n"
                        + "Oprindelsesår: " + superheroList.getHeroCreation() + "\n"
                        + "Er menneske: " + superheroList.getHuman() + "\n"
                        + "Styrke: " + superheroList.getHeroPowerLevel());

            }
            startProgram();
        }
        else if (menuValg == 9) {
            System.out.println("program afsluttes");
        }
        else{
            System.out.println("Ugyldigt input");
        }
    }
}
