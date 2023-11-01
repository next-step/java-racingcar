package study.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringDelimiter {

    private final String origin;

    public StringDelimiter(String origin) {
        this.origin = origin;
    }

    public List<String> filteredString(Delimiter delimiter) {
        String[] split = origin.split(delimiter.delimiter());
        return Arrays.stream(split).collect(Collectors.toList());
    }
}
