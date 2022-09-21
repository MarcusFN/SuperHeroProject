import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
    public void setup() {
        //Arrange
        Database database = new Database();
        Database createTestData;
    }

    @Test
    void createOneSuperHero() {
        //Arrange
        Database database = new Database();

        //act
        database.createSuperHero("Batman", "Bruce Wayne", true, "Rig", 2001, 2);
        ArrayList<Superhero> results = database.getSuperheroesList();

        int expected = 1;
        int actual = results.size();

        //assert
        assertEquals(expected, actual);

    }

    @Test
    void createTestData() {
        //Arrange
        Database database = new Database();


        //act
        database.createSuperHero("Batman", "Bruce Wayne", true, "Rig", 2001, 2);
        ArrayList<Superhero> results = database.getSuperheroesList();

        int expected = 1;
        int actual = results.size();

        //assert
        assertEquals(expected, actual);

    }

    @Test
    void searchForMulitipleResults() {

        //act
        ArrayList<Superhero> results = database.findSuperhero("man");

        int expected = 4;
        int actual = results.size();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void deleteSuperhero(){

        ArrayList<Superhero> results = database.getSuperheroesList();

        Superhero superhero = results.get(0);
        boolean actualResult = database.deleteSuperhero( superhero );
        boolean exspectedResult = true;

        assertEquals(exspectedResult, actualResult);

        int exspectedSize = results.size();
        ArrayList<Superhero> resultsAfterDelete = database.getSuperheroesList();
        int actualSize = resultsAfterDelete.size();
        assertEquals(exspectedSize, actualSize);


    }

}