import items.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {

    ShoppingBasket basket;

    @Before
    public void setUp() throws Exception {
        basket = new ShoppingBasket();
    }

    @Test
    public void shouldCheckoutBasketGivenANormalItem(){

        Item normalItem = Item.create("music CD at 14.99");

        basket.addLineItem(1,normalItem);

        Receipt receipt = basket.checkout();
        assertNotNull(receipt);
        assertEquals("Total: 16.49",receipt.total());
    }

    @Test
    public void shouldAddToBasket(){
        Item normalItem = Item.create("music CD at 14.99");

        assertEquals(basket.addLineItem(1,normalItem),"1 music CD at 14.99");
    }
}
