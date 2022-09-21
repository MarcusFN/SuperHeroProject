import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Database database = new Database();
    private String name;
    boolean userValgFalse = false;


    public void menu() {
        database.testData();
        int menuValg = 0;
        while (menuValg != 9) {
            System.out.println("\n" +
                    "Superhero Universets Database!\n" +
                    "1. Opret superhelt\n" +
                    "2. Vis Superhelte liste\n" +
                    "3. Søg efter superhelt\n" +
                    "4. Edit superhelte\n" +
                    "9. Afslut program");

            do {
                String valg = scanner.nextLine();
                try {
                    menuValg = Integer.parseInt(valg);
                    userValgFalse = true;
                    startProgram(menuValg);
                } catch (NumberFormatException e) {
                    System.out.println("der er sket en fejl, prøv igen med gyldigt input: ");
                }
            } while (userValgFalse == false);
        }
    }

    public void startProgram(int menuValg) {
        if (menuValg == 1) {
            this.createSuperhero();
        } else if (menuValg == 2) {
            showListOfSuperHeroes();
        } else if (menuValg == 3) {
            searchSuperhero();
        } else if (menuValg == 4) {
            editSuperheroes();
        } else if (menuValg == 9) {
            System.out.println("program afsluttes");
        }
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

    public void showListOfSuperHeroes() {
        System.out.println("Liste af superhelte:");
        for (Superhero superheroList : database.getSuperheroesList()) {
            System.out.println("----------------\n"
                    + "Superhelte navn: " + superheroList.getHeroName() + "\n"
                    + "Rigtige navn: " + superheroList.getHeroRealName() + "\n"
                    + "Superkraft: " + superheroList.getHeroPowers() + "\n"
                    + "Oprindelsesår: " + superheroList.getHeroCreation() + "\n"
                    + "Er menneske: " + superheroList.getHuman() + "\n"
                    + "Styrke: " + superheroList.getHeroPowerLevel());

        }
    }

    public void searchSuperhero() {
        System.out.println("------------------\nIndtast den superhelt du vil søge efter: ");
        String searchTerm = scanner.nextLine();

        for (Superhero superhero : database.findSuperhero(searchTerm)) {
            System.out.println("----------------\n"
                    + "Superhelte navn: " + superhero.getHeroName() + "\n"
                    + "Rigtige navn navn: " + superhero.getHeroRealName() + "\n"
                    + "Superkraft: " + superhero.getHeroPowers() + "\n"
                    + "Oprindelsesår: " + superhero.getHeroCreation() + "\n"
                    + "Er menneske: " + superhero.getHuman() + "\n"
                    + "Styrke: " + superhero.getHeroPowerLevel());

            //tilføjer searchTerm fra input til database til søgning


        }

    }

    public void editSuperheroes() {
        System.out.println("indtast den superhelt som du vil redigere: ");
        String searchTermEdit = scanner.nextLine();
        ArrayList<Superhero> seachEditResult = new ArrayList<>();

        int index = 1;

        for (Superhero searchResult : database.findSuperhero(searchTermEdit)) {
            name = searchResult.getHeroName().toLowerCase();
            if (name.contains(searchTermEdit.toLowerCase())) {
                seachEditResult.add(searchResult);
                System.out.println(index++ + " " + searchResult.getHeroName());
            }
        }

        System.out.print("Indtast nummeret på den superhero du vil redigere: ");
        String userEditNumberString = scanner.nextLine();
        int userEditNumberInteger = Integer.parseInt(userEditNumberString);


        Superhero editSuperhero = seachEditResult.get(index - 1);
        System.out.println("Redigere: " + editSuperhero);
        System.out.println("Ønsker du ikke redigere tryk ENTER for at fortsætte!");

        do {
            System.out.println("Indtast nummer på den superhelt du vil redigere: ");

            try {
                int intSuperheroEdit;
                String newPowerLevel = this.scanner.nextLine();
                intSuperheroEdit = Integer.parseInt(newPowerLevel);
                userValgFalse = true;
            } catch (NumberFormatException var12) {
                System.out.println("Indtast venligst gyldigt input ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Superhero navn " + editSuperhero.getHeroName());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedSuperheroName = scanner.nextLine();
                if (!editedSuperheroName.isEmpty()) {
                    editSuperhero.setHeroName(editedSuperheroName);
                }
                userValgFalse = true;
            } catch (NumberFormatException var11) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Superhero rigtige navn " + editSuperhero.getHeroRealName());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedSuperheroRealName = scanner.nextLine();
                if (!editedSuperheroRealName.isEmpty()) {
                    editSuperhero.setHeroRealName(editedSuperheroRealName);
                }
                userValgFalse = true;
            } catch (NumberFormatException var10) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Superhero superkraft " + editSuperhero.getHeroPowers());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedSuperheroPowers = scanner.nextLine();
                if (!editedSuperheroPowers.isEmpty()) {
                    editSuperhero.setHeroPowers(editedSuperheroPowers);
                }
                userValgFalse = true;
            } catch (NumberFormatException var9) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Superhero oprindelsesår " + editSuperhero.getHeroCreation());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedSuperheroCreation = scanner.nextLine();
                if (!editedSuperheroCreation.isEmpty()) {
                    editSuperhero.setHeroCreation(editedSuperheroCreation);
                }
                userValgFalse = true;
            } catch (NumberFormatException var8) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Er superhero menneske svar (j/n)" + editSuperhero.getHuman());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedSuperheroHuman = scanner.nextLine();
                if (!editedSuperheroHuman.isEmpty()) {
                    editSuperhero.setHuman(Boolean.parseBoolean(editedSuperheroHuman));
                }
                userValgFalse = true;
            } catch (NumberFormatException var7) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

        do {
            System.out.println("Superhero styrke " + editSuperhero.getHeroPowerLevel());

            try {
                System.out.println("indskriv rettelse her: ");
                String editedHeroPowerLevel = scanner.nextLine();
                if (!editedHeroPowerLevel.isEmpty()) {
                    editSuperhero.setHeroPowerLevel(editedHeroPowerLevel);
                }
                userValgFalse = true;
            } catch (NumberFormatException var6) {
                System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
            }

        } while (userValgFalse == false);

    }
}

