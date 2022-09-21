public class Superhero {
    private String heroName;
    private String heroRealName;
    private boolean isHuman;
    private String heroPowers;
    private int heroCreation;
    private double heroPowerLevel;

    //konstruktør
    public Superhero(String superHeroName, String reelName, boolean isHuman, String superPower, int creationYear, double powerLevel) {
        this.heroName = superHeroName;
        this.heroRealName = reelName;
        this.isHuman = isHuman;
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
    public boolean getHuman() {
        return isHuman;
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
    //setter nyt HeroName
    public void setHeroName(String editedHeroName) {
        this.heroName = editedHeroName;
    }

    // setter ny HeroRealName
    public void setHeroRealName(String editedHeroRealName) {
        this.heroRealName = editedHeroRealName;
    }

    // setter nyt realName
    public void setHuman(boolean editedHuman) {
        this.isHuman = editedHuman;
    }

    // setter ny power
    public void setHeroPowers(String editedHeroPowers) {
        this.heroPowers = editedHeroPowers;
    }

    // setter nyt
    public void setHeroCreation(int editedHeroCreation) {
        this.heroCreation = editedHeroCreation;
    }
    // setter nyt
    public void setHeroPowerLevel(double editedHeroPowerLevel) {
        this.heroPowerLevel = editedHeroPowerLevel;
    }



}
