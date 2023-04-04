package calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddSeparator {

    public List<String> getSeparatedString(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] numbers = null;
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
            return Arrays.asList(Objects.requireNonNull(numbers));
        }
        if (text.contains(",") || text.contains(":")) {
            return Arrays.asList(Objects.requireNonNull(text.split(",|:")));
        }
        return Collections.singletonList(text);
    }
}
