package stringcalculator;

import java.util.*;
import java.util.stream.Collectors;

import static stringcalculator.Delimiter.*;

public class Delimiters {
    private final Set<String> delimiters = new HashSet<>();

    private Delimiters(String text) {
        initializeDelimiters();
        validateDelimiter(text);
    }

    public static Delimiters of(String text) {
        return new Delimiters(text);
    }

    public List<String> split(String text) {
        String result = text;
        if (text.contains(CUSTOM_END_STRING.getValue())) {
            result = text.split(ESCAPE_CUSTOM_END_STRING.getValue())[1];
        }

        for (String delimiter : delimiters) {
            delimiter = REGEX_ESCAPE.getOrDefault(delimiter, delimiter);
            result = result.replaceAll(delimiter, BLANK_STRING.getValue());
        }

        return Arrays.stream(result.split(BLANK_STRING.getValue())).collect(Collectors.toList());
    }

    private void validateDelimiter(String text) {
        if (containsCustomDelimiter(text)) {
            final String customDelimiter = String.valueOf(text.charAt(2));
            delimiters.add(customDelimiter);
        }
    }

    public boolean containsDelimiters() {
        return !delimiters.isEmpty();
    }

    private void initializeDelimiters() {
        delimiters.add(COMMA.getValue());
        delimiters.add(COLON.getValue());
    }
}
