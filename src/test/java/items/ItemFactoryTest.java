package items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemFactoryTest {

    @Test
    public void shouldCreateANormalItem(){
        Item theItem=ItemFactory.create("music CD at 14.99");
        assertEquals(NormalItem.class,theItem.getClass());
    }

    @Test
    public void shouldCreateAExemptItem(){
        Item theItem=ItemFactory.create("book at 12.49");
        assertEquals(ExemptItem.class,theItem.getClass());
        theItem=ItemFactory.create("chocolate at 15.99");
        assertEquals(ExemptItem.class,theItem.getClass());
    }
}
