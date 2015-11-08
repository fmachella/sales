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
    public void shouldPrintReceiptForInput1Basket(){
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
    public void shouldPrintReceiptForInput1ExtraBasket(){
        console.addToBasket("10 book at 12.49");

        Receipt receipt = console.calculateReceipt();

        assertEquals("10 book: 124.90",receipt.printItemAt(0));
        assertEquals("Sales Taxes: 0.00",receipt.taxes());
        assertEquals("Total: 124.90",receipt.total());
    }

    @Test
    public void shouldPrintReceiptForInput2Basket(){
        console.addToBasket("1 imported box of chocolates at 10.00");
        console.addToBasket("1 imported bottle of perfume at 47.50");

        Receipt receipt = console.calculateReceipt();

        assertEquals("1 imported box of chocolates: 10.50",receipt.printItemAt(0));
        assertEquals("1 imported bottle of perfume: 54.65",receipt.printItemAt(1));
        assertEquals("Sales Taxes: 7.65",receipt.taxes());
        assertEquals("Total: 65.15",receipt.total());
    }

    @Test
    public void shouldPrintReceiptForInput3Basket(){
        console.addToBasket("1 imported bottle of perfume at 27.99");
        console.addToBasket("1 bottle of perfume at 18.99");
        console.addToBasket("1 packet of headache pills at 9.75");
        console.addToBasket("1 box of imported chocolates at 11.25");

        Receipt receipt = console.calculateReceipt();

        assertEquals("1 imported bottle of perfume: 32.19",receipt.printItemAt(0));
        assertEquals("1 bottle of perfume: 20.89",receipt.printItemAt(1));
        assertEquals("1 packet of headache pills: 9.75",receipt.printItemAt(2));
        assertEquals("1 imported box of chocolates: 11.85",receipt.printItemAt(3));
        assertEquals("Sales Taxes: 6.70",receipt.taxes());
        assertEquals("Total: 74.68",receipt.total());
    }


}
