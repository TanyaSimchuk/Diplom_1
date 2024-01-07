import edu.praktikum.Bun;
import edu.praktikum.Database;
import edu.praktikum.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }
    @Test
    public void testAvailableBuns() {
        List<Bun> availableBuns = database.availableBuns();
        assertEquals(3, availableBuns.size());
    }
    @Test
    public void testAvailableIngredients() {
        List<Ingredient> availableIngredients = database.availableIngredients();
        assertEquals(6, availableIngredients.size());
    }
}