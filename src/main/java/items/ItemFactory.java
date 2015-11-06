package items;

public class ItemFactory {

    public static Item create(String substring) {
        String[] splitted=substring.split(" at ");
        Item item;
        item = ExemptItem.create(splitted[0],splitted[1]);
        if (item != null) {
            return item;
        }
        return NormalItem.create(splitted[0],splitted[1]);
    }
}
