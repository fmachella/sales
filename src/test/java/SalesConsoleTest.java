import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesConsoleTest {
    private SalesConsole console;

    @Before
    public void setUp() throws Exception {
        console = new SalesConsole();
    }

    @Test
    public void shouldCheckoutInput1Basket(){
        console.addToBasket("1 book at 12.49");
        console.addToBasket("1 music CD at 14.99");
        console.addToBasket("1 chocolate bar at 0.85");

        Receipt receipt = console.calculateReceipt();

        assertEquals("1 book: 12.49",receipt.printItemAt(0));
        assertEquals("1 music CD: 16.49",receipt.printItemAt(1));
        assertEquals("1 chocolate bar: 0.85",receipt.printItemAt(2));
        assertEquals("Sales Taxes: 1.50",receipt.taxes());
        assertEquals("Total: 29.83",receipt.total());
    }
    @Test
    public void shouldCheckoutInput1ExtraBasket(){
        console.addToBasket("10 book at 12.49");

        Receipt receipt = console.calculateReceipt();

        assertEquals("10 book: 124.90",receipt.printItemAt(0));
        assertEquals("Sales Taxes: 0.00",receipt.taxes());
        assertEquals("Total: 124.90",receipt.total());
    }
}
