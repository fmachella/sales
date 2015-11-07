package items;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ItemFactoryTest {

    @Test
    public void shouldCreateANormalItem(){
        Item theItem=ItemFactory.create("music CD at 14.99");
        assertEquals(NormalItem.class,theItem.getClass());
    }

    @Test
    public void shouldCreateAnExemptItem(){
        Item theItem=ItemFactory.create("book at 12.49");
        assertEquals(ExemptItem.class,theItem.getClass());
        theItem=ItemFactory.create("chocolate at 15.99");
        assertEquals(ExemptItem.class,theItem.getClass());
    }

    @Test
    @Ignore
    public void shouldCreateAnExemptItemButImported(){
        Item theItem=ItemFactory.create("imported box of chocolates at 10.00");
        assertEquals(ExemptItem.class,theItem.getClass());
        assertEquals(BigDecimal.valueOf(5.0),theItem.tax());
    }
}
