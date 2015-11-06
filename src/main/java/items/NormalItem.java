package items;

import java.math.BigDecimal;

class NormalItem implements Item {
    private static BigDecimal taxPercent= BigDecimal.valueOf(0.1);

    public static NormalItem create(String description, String price){
        return new NormalItem(description,BigDecimal.valueOf(Double.parseDouble(price)));
    }

    private final String description;
    private final BigDecimal price;

    public NormalItem(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public BigDecimal grossPrice() {
        return price.multiply(taxPercent.add(BigDecimal.ONE));
    }

    @Override
    public BigDecimal tax() {
        return price.multiply(taxPercent);
    }

    @Override
    public String description() {
        return description;
    }

    public String toString(){
        return String.format("%s at %s",description,price.toPlainString());
    }
}
