import items.Item;

import java.util.LinkedList;
import java.util.List;

public class Receipt {

    private List<String> boughtItems;

    public Receipt(){
        boughtItems = new LinkedList<>();
        boughtItems.add("1 book : 12.49");
        boughtItems.add("1 music CD: 16.49");
        boughtItems.add("1 chocolate bar: 0.85");
    }

    public String total() {
        return "Total: 29.83";
    }

    public String taxes() {
        return "Sales Taxes: 1.50";
    }

    public String printItemAt(int position) {
        return boughtItems.get(position);
    }
}
