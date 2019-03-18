package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    private static final String DEFAULT_SEPARATOR = ",";

    public static List<String> split(String str) {
        return split(str, DEFAULT_SEPARATOR);
    }

    public static List<String> split(String str, String separator) {
        return Arrays.stream(str.split(separator))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
