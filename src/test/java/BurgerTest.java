import edu.praktikum.Bun;
import edu.praktikum.Burger;
import edu.praktikum.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static edu.praktikum.IngredientType.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    private final List<Ingredient> ingredients = new ArrayList<>();
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient;
    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(mockIngredient);
        burger.setBuns(mockBun);
    }

    @Test
    public void testAddIngredient() {
        assertTrue(ingredients.add(mockIngredient));
    }
    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        assertFalse(ingredients.contains(mockIngredient));
    }
    @Test
    public void testMoveIngredients() {
        burger.addIngredient(mockIngredient);
        burger.moveIngredient(0, 1);
        burger.removeIngredient(0);
        assertTrue(ingredients.add(mockIngredient));
    }
    @Test
    public void testGetPrice() {
        float mockBunPrice = mockBun.getPrice() * 2;
        float mockIngredientPrice = mockIngredient.getPrice();
        float result = mockBunPrice + mockIngredientPrice;
        assertEquals(result, burger.getPrice(), 0.001);
    }
    @Test
    public void testGetReceipt() {
        String bun = mockBun.getName();
        when(mockIngredient.getType()).thenReturn(SAUCE);
        when(mockIngredient.getType()).thenReturn(FILLING);
        String mockType = mockIngredient.getType().toString().toLowerCase();
        String mockName = mockIngredient.getName();
        float price = burger.getPrice();
        String receipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %,8.6f%n",
                bun, mockType, mockName, bun, price);
        assertEquals(receipt, burger.getReceipt());
    }
}
