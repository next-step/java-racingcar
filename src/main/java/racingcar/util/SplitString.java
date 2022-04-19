package racingcar.util;

import java.util.List;

public class SplitString {
    private static final String COMMA_DELIMITER = ",";

    private SplitString() {
    }

    public static List<String> split(String text) {
        return split(text, COMMA_DELIMITER);
    }

    private static List<String> split(String text, String delimiter) {
        return List.of(text.split(delimiter));
    }

}