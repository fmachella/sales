import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

    private ShoppingBasket basket;

    @Before
    public void before(){
        basket = new ShoppingBasket();
    }

    @Test
    public void shouldReflectAddedItemToBasket(){
        assertEquals(basket.addLineItem(1,"book at 12.49"),"1 book at 12.49");
        assertEquals(basket.addLineItem(1,"music CD at 14.99"),"1 music CD at 14.99");
        assertEquals(basket.addLineItem(1,"chocolate bar at 0.85"),"1 chocolate bar at 0.85");
    }

    @Test
    public void shouldPrintBasketList(){
        basket.addLineItem(1,"book at 12.49");
        basket.addLineItem(1,"music CD at 14.99");
        basket.addLineItem(1,"chocolate bar at 0.85");
        assertTrue(basket.listItems().size()!=0);
    }


}
