import org.junit.Test;
import static org.junit.Assert.*;
public class ShoppingBasketTest {

    @Test
    public void shouldReflectAddedItemToBasket(){
        ShoppingBasket basket = new ShoppingBasket();
        assertEquals(basket.addLineItem("1 book at 12.49"),"1 book at 12.49");
        assertEquals(basket.addLineItem("1 music CD at 14.99"),"1 music CD at 14.99");
        assertEquals(basket.addLineItem("1 chocolate bar at 0.85"),"1 chocolate bar at 0.85");
    }
}
