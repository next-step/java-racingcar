package lotto;

import java.util.ArrayList;
import java.util.List;

public class DelimiterList {

    private List<String> delimiter;
    private final static String COMMA = ",";
    private final static String COLON = ":";
    private final static String VERTICAL_BAR = "|";

    public DelimiterList() {
        this.delimiter = new ArrayList<>();
        this.delimiter.add(COMMA);
        this.delimiter.add(COLON);
    }

    public void addCustomDelimiter(String value) {
        if (value != null && value.isEmpty() == false) {
            this.delimiter.add(value);
        }
    }

    public String toSplitRegex() {
        return String.join(VERTICAL_BAR, delimiter);
    }
}
