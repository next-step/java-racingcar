package study.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class StringDelimiter {

    private final Delimiter delimiter;

    public StringDelimiter(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> filteredString(String target) {
        Matcher matcher = Delimiter.DELLIMITER_PATTERN.matcher(target);
        if (matcher.find()) {
            String[] split = matcher.group(2).split(delimiter.delimiter());
            return Arrays.stream(split).collect(Collectors.toList());
        }
        return Arrays.stream(target.split(delimiter.delimiter())).collect(Collectors.toList());
    }
}
