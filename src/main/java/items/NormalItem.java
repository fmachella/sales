package items;

import java.math.BigDecimal;

class NormalItem extends Item {
    private static BigDecimal taxPercent= BigDecimal.valueOf(0.1);

    public NormalItem(String description, BigDecimal price) {
        super(description,price);
    }

    @Override
    public BigDecimal taxPercent() {
        return taxPercent;
    }


}
