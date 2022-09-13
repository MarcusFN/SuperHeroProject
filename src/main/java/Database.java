import java.util.ArrayList;

public class Database {



    private ArrayList<Superhero>superheroes = new ArrayList<>();

    public void createSuperHero(String heroName, String heroRealName, boolean heroHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, heroHuman, heroPowers, heroCreation, heroPowerLevel);
       superheroes.add(newSuperHero);
    }


public boolean showListSuperheroes(){
        for (Superhero superhero : superheroes){
            System.out.println("----------------\n"
                    + "Superheltenavn: " + superhero.getHeroName()+ "\n"
                    + "Superkraft: " + superhero.getHeroPowers()+ "\n"
                    + "Virkelige navn: " + superhero.getHeroRealName()+ "\n"
                    + "Oprindelsesår: " + superhero.getHeroCreation()+ "\n"
                    + "Er menneske: " + superhero.getHeroHuman()+ "\n"
                    + "Styrke: " + superhero.getHeroPowerLevel());

        }
    return showListSuperheroes();
    }
}
