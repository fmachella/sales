package items;

import java.math.BigDecimal;

public abstract class Item {
    private final String description;
    private final BigDecimal price;

    public Item(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public BigDecimal grossPrice() {
        return price.multiply(taxPercent().add(BigDecimal.ONE));
    }

    public BigDecimal tax() {
        return price.multiply(taxPercent());
    }

    public String description() {
        return description;
    }

    public abstract BigDecimal taxPercent();

    public String toString(){
        return String.format("%s at %s",description,price.toPlainString());
    }
}
