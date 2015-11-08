import items.Item;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LineItemTest {

    @Test
    public void shouldRoundUpTo5() throws Exception {
        Item imported_bottle=Item.create("imported bottle of perfume at 47.50");
        LineItem an_imported_bottle=new LineItem(1,imported_bottle);
        assertEquals(BigDecimal.valueOf(7.15),an_imported_bottle.tax());
        assertEquals(BigDecimal.valueOf(54.65),an_imported_bottle.calculatePartial());
        Item imported_lollo=Item.create("imported bottle of lollo at 30.75");
        LineItem imported_lollo_line=new LineItem(1,imported_lollo);
        assertEquals(BigDecimal.valueOf(35.40).setScale(2),imported_lollo_line.calculatePartial());
    }

}