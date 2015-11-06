import items.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<Item,Integer> lineItems = new HashMap<>();

    public String addLineItem(Integer quantity, Item item){
        lineItems.put(item,quantity);
        return quantity.toString() + ' '+ item;
    }

    public Collection listItems() {
        return lineItems.keySet();
    }
}
