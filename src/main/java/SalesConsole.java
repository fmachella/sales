import items.Item;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesConsole {

    private ShoppingBasket basket = new ShoppingBasket();

    public void addToBasket(String lineItem) {
        Matcher m = parseInput(lineItem);

        String stringQuantity = m.group(1);
        String text = m.group(2);
        String stringPrice = m.group(3);

        Integer itemQuantity = Integer.parseInt(stringQuantity);
        BigDecimal price = BigDecimal.valueOf(Float.parseFloat(stringPrice));
        Item item = Item.create(text, price);
        basket.addLineItem(itemQuantity,item);
    }

    public Receipt calculateReceipt() {
        return basket.checkout();
    }


    private Matcher parseInput(String lineItem) {
        Pattern p = Pattern.compile("([0-9]+) (.*) at (.*)");
        Matcher m = p.matcher(lineItem);
        m.matches();
        return m;
    }

}
