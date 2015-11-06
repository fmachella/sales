import items.Item;
import items.ItemFactory;

/**
 * Created by fprivato on 06/11/15.
 */
public class SalesConsole {

    private ShoppingBasket basket = new ShoppingBasket();

    public void addToBasket(String lineItem) {
        Integer itemQuantity = Integer.parseInt(lineItem.substring(0,1));
        Item item = ItemFactory.create(lineItem.substring(1));
        basket.addLineItem(itemQuantity,item);
    }

    public Receipt calculateReceipt() {
        return new Receipt();
    }

}
