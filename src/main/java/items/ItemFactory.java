package items;

import java.math.BigDecimal;

public class ItemFactory {

    public static Item create(String substring) {
        String[] desc_and_price=substring.split(" at ");
        String description = desc_and_price[0];
        String price = desc_and_price[1];
        if (description.matches(".*(book|chocolate|pills).*")){
            return new ExemptItem(description, BigDecimal.valueOf(Double.parseDouble(price)));
        }
        return new NormalItem(description, BigDecimal.valueOf(Double.parseDouble(price)));
    }
}
