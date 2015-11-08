package items;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class Item {

    public static Item create(String description, BigDecimal price) {
        BigDecimal taxPercent = valueOf(0.1);
        if (description.matches(".*(book|chocolate|pills).*")){
            taxPercent=BigDecimal.ZERO;
        }
        if(description.matches(".*import.*")){
            return new ImportedItem(description,price,taxPercent);
        }
        return new Item(description, price, taxPercent);
    }


    protected final String description;
    protected final BigDecimal price;
    protected BigDecimal taxPercent;

    public Item(String description, BigDecimal price, BigDecimal taxPercent) {
        this.description = description;
        this.price = price;
        this.taxPercent = taxPercent;
    }

    public BigDecimal grossPrice() {
        return price.add(tax());
    }

    public BigDecimal tax() {
        BigDecimal math_rounded =price.multiply(taxPercent).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal adjusted_decimal = roundUpTo05(math_rounded);
        return math_rounded.add(adjusted_decimal);
    }

    public String description() {
        return description;
    }

    public String toString(){
        return String.format("%s at %s",description,price.toPlainString());
    }

    private BigDecimal roundUpTo05(BigDecimal math_rounded) {
        BigDecimal differences = math_rounded.remainder(BigDecimal.ONE).remainder(valueOf(0.05));
        return BigDecimal.ZERO.compareTo(differences) != 0 ? valueOf(0.05).subtract(differences) : BigDecimal.ZERO;
    }

}
