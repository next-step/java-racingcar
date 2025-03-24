package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String COMMA = ",";

    public static List<String> splitByComma(String value) {
        return Arrays.stream(value.split(COMMA))
            .collect(Collectors.toList());
    }

    public static boolean isLengthInvalid(String value, int maxLength) {
        return value.isEmpty() || value.length() > maxLength;
    }

    public static String joinByComma(List<String> values) {
        return  String.join(COMMA, values);
    }
}
