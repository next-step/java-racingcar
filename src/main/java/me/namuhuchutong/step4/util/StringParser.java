package me.namuhuchutong.step4.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private static final String DEFAULT_PATTERN = ",";

    public static List<String> parse(String text) {
        return parse(text, DEFAULT_PATTERN);
    }

    public static List<String> parse(String text, String pattern) {
        pattern = pattern == null ? DEFAULT_PATTERN : pattern;
        return Stream.of(text.split(pattern))
                     .collect(Collectors.toList());
    }
}
