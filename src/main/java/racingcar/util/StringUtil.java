package racingcar.util;

import racingcar.exception.ErrorMessage;

import java.util.Arrays;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }

    public static String[] splitValues(final String values, final String delimiter) {
        if (isEmpty(values) || delimiter == null) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
        return Arrays.stream(values.split(delimiter))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
