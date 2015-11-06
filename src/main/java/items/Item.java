package items;

import java.math.BigDecimal;

public interface Item {
    BigDecimal grossPrice();

    BigDecimal tax();

    String description();

}
