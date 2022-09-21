import java.util.ArrayList;

public class Database {
    //testdata
    public void testData() {
        createSuperHero("Batman", "Bruce Wayne", true, "Rig", 2001, 50);
        createSuperHero("Iron Man", "Tony Stark", true, "Flyve", 1998, 40);
        createSuperHero("Black Panther", "ved ikke", true, "Rig", 2001, 30);
        createSuperHero("Superman", "ved ikke", true, "Rig", 2001, 45);
        createSuperHero("Running man", "ved ikke", true, "Rig", 2001, 99);
    }

    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperHero(String heroName, String heroRealName, boolean isHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, isHuman, heroPowers, heroCreation, heroPowerLevel);
        superheroes.add(newSuperHero);
    }

    //getter til superhero ArrayList
    public ArrayList<Superhero> getSuperheroesList() {
        return superheroes;
    }

    public ArrayList<Superhero> findSuperhero(String searchTerm) {
        ArrayList<Superhero> searchResult = new ArrayList<Superhero>();
        for (Superhero hero : superheroes) {
            if (hero.getHeroName().contains(searchTerm)) {
                searchResult.add(hero);
            }
        }
        return searchResult;
    }
}