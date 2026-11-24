package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    private static final String DELIMITER = ",";
    private static final int KEEP_TRAILING_EMPTY = -1;

    private NameParser() {
    }

    public static List<String> parse(String input) {
        validateNotBlank(input);
        List<String> names = Arrays.stream(input.split(DELIMITER, KEEP_TRAILING_EMPTY))
                .map(String::trim)
                .toList();
        validateNoEmptyName(names, input);
        return names;
    }

    private static void validateNoEmptyName(List<String> names, String input) {
        if (names.contains("")) {
            throw new IllegalArgumentException("empty name is not allowed [" + input + "]");
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("car names are required");
        }
    }
}
