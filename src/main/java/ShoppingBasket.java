import items.Item;

import java.util.*;

import static java.lang.String.format;

public class ShoppingBasket {

    private List<LineItem> lineItems = new ArrayList<>();

    public String addLineItem(Integer quantity, Item item){
        lineItems.add(new LineItem(quantity,item));
        return format("%d %s",quantity,item);
    }

    public Receipt checkout() {
        return new Receipt(Collections.unmodifiableList(lineItems));
    }

}
