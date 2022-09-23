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
                    "5. delete superhero\n" +
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
            createSuperhero();
        } else if (menuValg == 2) {
            showListOfSuperHeroes();
        } else if (menuValg == 3) {
            searchSuperhero();
        } else if (menuValg == 4) {
            editSuperheroes();
        } else if (menuValg == 5) {
            deleteSuperhero();
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
            name = superhero.getHeroName().toLowerCase();
            if (name.contains(searchTerm.toLowerCase())) {
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
    }

    public void editSuperheroes () {
            System.out.println("indtast navnet på den superhelt du ønsker at redigere: ");
            System.out.println("---------------------------");
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


            Superhero editSuperhero = seachEditResult.get(userEditNumberInteger - 1);
            System.out.println("Du ønsker at redigere: " + editSuperhero.getHeroName());
            System.out.println("---------------------------");
            System.out.println("Ønsker du ikke redigere tryk ENTER for at fortsætte ");


            do {
                System.out.println("Superhero navn er nu " + editSuperhero.getHeroName());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedSuperheroName = scanner.nextLine().trim();
                    if (!editedSuperheroName.isEmpty()) {
                        editSuperhero.setHeroName(editedSuperheroName);
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

            do {
                System.out.println("Superhero rigtige navn er nu: " + editSuperhero.getHeroRealName());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedSuperheroRealName = scanner.nextLine().trim();
                    if (!editedSuperheroRealName.isEmpty()) {
                        editSuperhero.setHeroRealName(editedSuperheroRealName);
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

            do {
                System.out.println("Superhero superkrafter: " + editSuperhero.getHeroPowers());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedSuperheroPowers = scanner.nextLine().trim();
                    if (!editedSuperheroPowers.isEmpty()) {
                        editSuperhero.setHeroPowers(editedSuperheroPowers);
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

            do {
                System.out.println("Superhero oprindelsesår: " + editSuperhero.getHeroCreation());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedSuperheroCreation = scanner.nextLine().trim();
                    if (!editedSuperheroCreation.isEmpty()) {
                        editSuperhero.setHeroCreation(Integer.parseInt(editedSuperheroCreation));
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

            do {
                System.out.println("Er superhero menneske svar (j/n)" + editSuperhero.getHuman());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedSuperheroHuman = scanner.nextLine().trim();
                    if (!editedSuperheroHuman.isEmpty()) {
                        editSuperhero.setHuman(Boolean.parseBoolean(editedSuperheroHuman));
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

            do {
                System.out.println("Superhero styrke: " + editSuperhero.getHeroPowerLevel());

                try {
                    System.out.println("indskriv rettelse her: ");
                    String editedHeroPowerLevel = scanner.nextLine().trim();


                    if (!editedHeroPowerLevel.isEmpty()) {
                        editSuperhero.setHeroPowerLevel(Double.parseDouble(editedHeroPowerLevel));
                    }
                    userValgFalse = true;
                } catch (NumberFormatException e) {
                    System.out.println("indskriv din rettelse her eller klik kun enter hvis intet skal ændres: ");
                }

            } while (userValgFalse == false);

        }

        public void deleteSuperhero () {
            System.out.println("indtast navnet på den superhelt du ønsker at slette: ");
            System.out.println("---------------------------");


            String searchTermDelete = scanner.nextLine();
            ArrayList<Superhero> searchDeleteEdit = new ArrayList<>();

            int index = 1;

            for (Superhero deleteSuperhero : database.getSuperheroesList()) {
                name = deleteSuperhero.getHeroName().toLowerCase();
                if (name.contains(searchTermDelete.toLowerCase())) {
                    searchDeleteEdit.add(deleteSuperhero);
                    System.out.println(index++ + ":" + deleteSuperhero.getHeroName());
                }
            }

            System.out.print("Indtast nummeret på den superhero du ønsker at slette: ");
            String deleteNumberString = scanner.nextLine();
            int deleteNumberInt = Integer.parseInt(deleteNumberString);


            Superhero deleteSuperhero = searchDeleteEdit.get(deleteNumberInt - 1);
            database.deleteSuperhero(deleteSuperhero);
            System.out.println("du har nu slettet " + deleteSuperhero.getHeroName());

        }

}