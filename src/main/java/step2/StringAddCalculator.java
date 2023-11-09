package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String COMMA_AND_COLON = "[,:]";
    private static final int GROUP_ONE = 1;
    private static final int GROUP_TWO = 2;

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) return 0;
        return Arrays.stream(splitString(text))
                     .map(StringAddCalculator::convertStringToInteger)
                     .reduce(0, Integer::sum);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitString(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(GROUP_ONE);
            return matcher.group(GROUP_TWO).split(customDelimiter);
        }

        return text.split(COMMA_AND_COLON);
    }

    private static Integer convertStringToInteger(String splitString) {
        Integer integer = Integer.valueOf(splitString);
        if (isNegative(integer)) {
            throw new IllegalArgumentException("음수는 파라미터로 사용할 수 없습니다. 음수 : " + integer);
        }
        return integer;
    }

    private static boolean isNegative(Integer integer) {
        return integer < 0;
    }
}

