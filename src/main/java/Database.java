import java.util.ArrayList;

public class Database {



    private ArrayList<Superhero>superheroes = new ArrayList<>();

    public void createSuperHero(String heroName, String heroRealName, boolean isHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, isHuman, heroPowers, heroCreation, heroPowerLevel);
       superheroes.add(newSuperHero);
    }


public void showListSuperheroes() {
    for (Superhero superhero : superheroes) {
        System.out.println("----------------\n"
                + "Superheltenavn: " + superhero.getHeroName() + "\n"
                + "Superkraft: " + superhero.getHeroPowers() + "\n"
                + "Virkelige navn: " + superhero.getHeroRealName() + "\n"
                + "Oprindelsesår: " + superhero.getHeroCreation() + "\n"
                + "Er menneske: " + superhero.getHuman() + "\n"
                + "Styrke: " + superhero.getHeroPowerLevel());

    }
}


}
