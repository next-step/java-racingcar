package step2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {
    private static final int EMPTY_RESULT = 0;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";

    private static final String IS_NUMBER_PATTERN = "\\d+";


    public static int splitAndSum(String text) {

        int sum = EMPTY_RESULT;
        if (isNullOrEmpty(text)) {
            return sum;
        }

        String[] tokens = splitText(text);
        for (String token : tokens) {
            validation(token);
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(delimiter);
            return tokens;
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isInvalidNumber(String number) {
        return !number.matches(IS_NUMBER_PATTERN);
    }

    private static void validation(String number) {
        if (isInvalidNumber(number)) {
            throw new RuntimeException("숫자 이외의 값 또는 음수 값 전달");
        }
    }


}
