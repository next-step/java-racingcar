package step3.utils;

import java.util.List;

public class StringSpliter {
    private static final String DEFAULT_DELIMITER = ",";

    public static List<String> split(String string) {
        return List.of(string.split(DEFAULT_DELIMITER));
    }
}
