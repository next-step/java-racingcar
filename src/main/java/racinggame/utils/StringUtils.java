package racinggame.utils;

import static java.util.Objects.isNull;

import java.util.List;

public class StringUtils {

    public static List<String> splitToList(String input, String delimiter) {
        if (isNotExistString(input)) {
            return List.of();
        }

        return List.of(
                input.split(delimiter)
        );
    }

    public static boolean isNotExistString(String input) {
        return isNull(input) || input.isBlank();
    }
}
