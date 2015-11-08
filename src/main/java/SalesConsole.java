import items.Item;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesConsole {

    private ShoppingBasket basket = new ShoppingBasket();

    public void addToBasket(String lineItem) {
        Matcher m = parseInput(lineItem);

        String stringQuantity = m.group(1);
        String rest = m.group(2);

        Integer itemQuantity = Integer.parseInt(stringQuantity);
        Item item = Item.create(rest);
        basket.addLineItem(itemQuantity,item);
    }

    public Receipt calculateReceipt() {
        return basket.checkout();
    }


    private Matcher parseInput(String lineItem) {
        Pattern p = Pattern.compile("([0-9]+) (.*)");
        Matcher m = p.matcher(lineItem);
        m.matches();
        return m;
    }

}
