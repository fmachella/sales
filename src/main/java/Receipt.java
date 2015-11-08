import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;

public class Receipt {

    private List<LineItem> boughtLineItems;

    public Receipt(List<LineItem> boughtLineItems){
        this.boughtLineItems = boughtLineItems;
    }

    public String total() {
        BigDecimal bigDecimalTotal = BigDecimal.ZERO;
        for (LineItem boughtLineItem : boughtLineItems) {
            bigDecimalTotal=bigDecimalTotal.add(boughtLineItem.calculatePartial());
        }
        return format("Total: %s", bigDecimalTotal.toPlainString());
    }

    public String taxes() {
        BigDecimal taxes = BigDecimal.ZERO;
        for (LineItem boughtLineItem : boughtLineItems) {
            taxes=taxes.add(boughtLineItem.tax());
        }
        return format("Sales Taxes: %s", taxes.toPlainString());
    }

    public String printItemAt(int position) {
        LineItem theItem = boughtLineItems.get(position);
        BigDecimal lineItemPartial= theItem.calculatePartial();
        return format("%d %s: %s",theItem.quantity(), theItem.description(), lineItemPartial.toPlainString());
    }

    @Override
    public String toString() {
        StringBuffer paper = new StringBuffer();
        for (int linePosition = 0; linePosition < boughtLineItems.size(); linePosition++) {
             paper.append(printItemAt(linePosition)).append('\n');
        }
        paper.append(taxes()).append('\n');
        paper.append(total());
        return paper.toString();
    }
}
