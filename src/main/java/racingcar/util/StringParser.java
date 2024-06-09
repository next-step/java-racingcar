package racingcar.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {
    private static final String SPLIT_PATTERN = ",";

    private StringParser() {}

    public static List<String> parse(String text) {
        return parse(text, SPLIT_PATTERN);
    }

    public static List<String> parse(String text, String pattern) {
        Objects.requireNonNull(pattern, SPLIT_PATTERN);
        return Stream.of(text.split(pattern))
                .collect(Collectors.toList());
    }
}
