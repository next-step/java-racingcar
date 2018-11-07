package coordinate;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    static List<Integer> parse(String text) {
        String escapeValue = text.substring(1, text.length() - 1);
        String[] values = escapeValue.split(",");

        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(Integer.parseInt(value));
        }
        return numbers;
    }
}
