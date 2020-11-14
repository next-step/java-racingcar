package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DelimiterList {

    private List<String> delimiter;
    private final static String COMMA = ",";
    private final static String COLON = ":";


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

    public Iterator<String> iterator() {
        return this.delimiter.iterator();
    }
}
