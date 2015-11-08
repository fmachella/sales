package items;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.math.BigDecimal.valueOf;

public class ImportedItem extends Item {

    public ImportedItem(String description, BigDecimal price, BigDecimal taxPercent) {
        super(description, price, taxPercent.add(valueOf(0.05)));
    }

    @Override
    public String description(){
        if (description.startsWith("imported")){
            return description;
        }
        Matcher matcher = extractImport(description);
        return format("imported %s %s", matcher.group(1), matcher.group(2));
    }

    private Matcher extractImport(String lineItem) {
        Pattern p = Pattern.compile("(.*) imported (.*)");
        Matcher m = p.matcher(lineItem);
        m.matches();
        return m;
    }

}
