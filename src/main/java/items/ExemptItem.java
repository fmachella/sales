package items;

import java.math.BigDecimal;

class ExemptItem implements Item{

    private static BigDecimal taxPercent= BigDecimal.ZERO;
    public static ExemptItem create(String description, String price){
        ExemptItem instance=null;
        if (description.matches(".*(book|chocolate|pills).*")){
            double parsed = Double.parseDouble(price);
            BigDecimal bdparsed = BigDecimal.valueOf(parsed);
            instance=new ExemptItem(description, bdparsed);
        }
        return instance;
    }

    private final String description;
    private final BigDecimal price;

    public ExemptItem(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public BigDecimal grossPrice() {
        return price;
    }

    @Override
    public BigDecimal tax() {
        return taxPercent;
    }

    @Override
    public String description() {
        return description;
    }

    public String toString(){
        return String.format("%s at %s",description,price.toPlainString());
    }
}
