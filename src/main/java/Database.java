import java.util.ArrayList;

public class Database {



    private ArrayList<Superhero>superheroes = new ArrayList<>();

    public void createSuperHero(String heroName, String heroRealName, boolean heroHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, heroHuman, heroPowers, heroCreation, heroPowerLevel);
       superheroes.add(newSuperHero);
    }







}
