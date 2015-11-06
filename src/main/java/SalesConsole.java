import items.Item;
import items.ItemFactory;

public class SalesConsole {

    private ShoppingBasket basket = new ShoppingBasket();

    public void addToBasket(String lineItem) {
        Integer itemQuantity = Integer.parseInt(lineItem.substring(0,1));
        Item item = ItemFactory.create(lineItem.substring(2));
        basket.addLineItem(itemQuantity,item);
    }

    public Receipt calculateReceipt() {
        return basket.checkout();
    }

}
