import items.Item;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class LineItem {
    private final Integer quantity;
    private final Item object;

    public LineItem(Integer quantity, Item object){
        this.quantity = quantity;
        this.object = object;
    }

    public Integer quantity(){
        return quantity;
    }

    public String description(){
        return object.description();
    }

    public BigDecimal calculatePartial() {
        return calculateWithRoundUp(object.grossPrice());
    }

    public BigDecimal tax() {
        return calculateWithRoundUp(object.tax());
    }

    private BigDecimal calculateWithRoundUp(BigDecimal tax) {
        return valueOf(quantity).multiply(tax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}