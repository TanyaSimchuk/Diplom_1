import edu.praktikum.Bun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {
    private Bun bun;
    @Parameterized.Parameter
    public String bunName;
    @Parameterized.Parameter(1)
    public float bunPrice;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void testGetName() {
        String result = bun.getName();
        assertEquals(result, bunName);
    }
    @Test
    public void testGetPrice() {
        float result = bun.getPrice();
        assertEquals(result, bunPrice, 0.001);
    }
}

