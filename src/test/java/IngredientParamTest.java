import edu.praktikum.Ingredient;
import edu.praktikum.IngredientType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientParamTest {
    private Ingredient ingredient;
    @Parameterized.Parameter
    public IngredientType type;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        float result = ingredient.getPrice();
        assertEquals(result, ingredient.price, 0.001);
    }
    @Test
    public void testGetName() {
        String result = ingredient.getName();
        assertEquals(result, ingredient.name);
    }
    @Test
    public void testGetType() {
        IngredientType result = ingredient.getType();
        assertEquals(result, ingredient.type);
    }
}
