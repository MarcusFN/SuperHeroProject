import java.util.ArrayList;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void createSuperHero(String heroName, String heroRealName, boolean isHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, isHuman, heroPowers, heroCreation, heroPowerLevel);
        superheroes.add(newSuperHero);
    }


    public ArrayList<Superhero> getSuperheroesList() {
        return superheroes;
    }

    public Superhero searchFor(String searchTerm) {
        for (Superhero superhero : superheroes) {
            String name = superhero.getHeroName().toLowerCase();
            if (name.contains(searchTerm.toLowerCase())) {
                return superhero;
            } else {
                System.out.println("intet resultat fundet");
            }
            return null;
        }

        return null;
    }
}
