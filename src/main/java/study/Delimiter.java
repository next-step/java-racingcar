package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private String delimiter;


    public Delimiter() {
        delimiter = null;
    }

    public Delimiter(String text) {
        List<String> delimiters = delimiters(text);
        delimiter = delimiterRegex(delimiters);
    }

    private String delimiterRegex(List<String> delimiters) {
        StringBuilder strBuilder = new StringBuilder();
        delimiters.stream().forEach(data -> strBuilder.append(data + "|"));
        return strBuilder.toString().substring(0, strBuilder.length() - 1);
    }

    private List<String> delimiters(String customDelimiter) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITER);

        if (customDelimiter != null) {
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    public String value() {
        return delimiter;
    }
}