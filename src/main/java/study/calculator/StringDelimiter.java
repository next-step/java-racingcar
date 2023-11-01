package study.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringDelimiter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private final String origin;

    public StringDelimiter(String origin) {
        this.origin = origin;
    }

    public List<String> filteredString(String delimiter) {
        String[] split = origin.split(DEFAULT_DELIMITER);
        return Arrays.stream(split).collect(Collectors.toList());
    }
}
