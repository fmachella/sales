import items.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    List<LineItem> boughtLineItems = createCart();

    @Test
    public void shouldCalculateTaxesGivenANormalItem(){
        Receipt receipt = new Receipt(boughtLineItems);
        assertEquals("Sales Taxes: 1.50",receipt.taxes());
    }

    @Test
    public void shouldPrintASingleLineReceipt(){
        Receipt receipt = new Receipt(boughtLineItems);
        assertEquals("1 generic: 16.49",receipt.printItemAt(0));
    }

    private List<LineItem> createCart(){
        List<LineItem> boughtLineItems = new ArrayList<>();
        boughtLineItems.add(new LineItem(1, Item.create("generic at 14.99")));
        return boughtLineItems;
    }
}
