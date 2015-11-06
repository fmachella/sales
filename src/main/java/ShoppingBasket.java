import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private Map<String,Integer> lineItems = new HashMap<String, Integer>();

    public String addLineItem(Integer quantity, String item){
        lineItems.put(item,quantity);
        return quantity.toString() + ' '+ item;
    }

    public Collection listItems() {
        return lineItems.keySet();
    }
}
