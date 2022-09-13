public class Database {
    private Superhero[] superheroes;
    private int antalSuperheros;
    private int superHeroesAmount;



    public Database(){
        superheroes = new Superhero[5];
        antalSuperheros = 0;
        superHeroesAmount = 0;
    }

    public void createSuperHero(String heroName, String heroRealName, boolean heroHuman, String heroPowers, int heroCreation, double heroPowerLevel) {
        Superhero newSuperHero = new Superhero(heroName, heroRealName, heroHuman, heroPowers, heroCreation, heroPowerLevel);
        superheroes[antalSuperheros++] = newSuperHero;
        superheroes[superHeroesAmount++] = newSuperHero;
    }


    public void setAntalSuperheros() {
        this.antalSuperheros = antalSuperheros;
    }
}