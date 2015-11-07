package items;

import java.math.BigDecimal;

class ExemptItem extends Item{

    private BigDecimal taxPercent=BigDecimal.ZERO;

    public ExemptItem(String description, BigDecimal price) {
        super(description,price);
    }

    @Override
    public BigDecimal taxPercent() {
        return taxPercent;
    }
}
