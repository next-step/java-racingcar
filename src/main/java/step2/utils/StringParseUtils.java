package step2.utils;

import step2.PositiveNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step2.constants.RegexConstants.EXTRACT_NUMBER_DYNAMIC_SEPARATOR;

public class StringParseUtils {

    public static boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }

    public static List<Integer> parseString(String numbers) {
        return Arrays.stream(numbers.split(EXTRACT_NUMBER_DYNAMIC_SEPARATOR))
                .filter(e -> !isNullOrEmpty(e))
                .map(PositiveNumber::get)
                .collect(Collectors.toList());
    }
}
