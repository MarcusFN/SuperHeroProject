public class Superhero {
    private String heroName;
    private String heroRealName;
    private boolean heroHuman;
    private String heroPowers;
    private int heroCreation;
    private double heroPowerLevel;

    //konstruktør
    public Superhero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        this.heroName = superHeroName;
        this.heroRealName = reelName;
        this.heroHuman = isHuman;
        this.heroPowers = superPower;
        this.heroCreation = creationYear;
        this.heroPowerLevel = powerLevel;
    }

    //Gettere
    public String getHeroName() {
        return heroName;
    }
    public String getHeroRealName() {
        return heroRealName;
    }
    public boolean getHeroHuman() {
        return heroHuman;
    }
    public String getHeroPowers() {
        return heroPowers;
    }
    public int getHeroCreation() {
        return heroCreation;
    }
    public double getHeroPowerLevel() {
        return heroPowerLevel;
    }


    public void setSuperhelteNavn() {
        this.heroName = heroName;
    }

}
