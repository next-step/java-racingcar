package step2.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step2.constants.RegexConstants.EXTRACT_NUMBER_ONLY;

public class StringParseUtils {

    public static Boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }

    public static int positiveNumber(String number) {
        int num = Integer.parseInt(number);

        if (num < 0) {
            throw new RuntimeException("음수는 더할 수 없습니다.");
        }

        return num;
    }

    public static List<Integer> parseString(String numbers) {
        return Arrays.stream(numbers.split(EXTRACT_NUMBER_ONLY))
                .filter(e -> !isNullOrEmpty(e))
                .map(StringParseUtils::positiveNumber)
                .collect(Collectors.toList());
    }
}
