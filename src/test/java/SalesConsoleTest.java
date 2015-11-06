import org.junit.Test;

import static org.junit.Assert.*;

public class SalesConsoleTest {

    @Test
    public void shouldCheckoutInput1Basket(){

        SalesConsole console = new SalesConsole();


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
}
