package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    public String toSplitRegex() {
        return delimiter.stream()
                .collect(Collectors.joining("|"));
    }

    public Iterator<String> iterator() {
        return this.delimiter.iterator();
    }
}
