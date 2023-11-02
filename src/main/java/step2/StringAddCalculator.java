package step2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Integer DEFUALT_VALUE = 0;
    private static final Integer STRING_LENGTH_ONE = 1;

    public static int splitAndSum(String sumStr) {
        if (checkForNullOrBlank(sumStr)) {
            return DEFUALT_VALUE;
        }

        if (sumStr.length() == STRING_LENGTH_ONE) {
            return validatePositiveInteger(sumStr);
        }

        return addition(extractNumbersFromSeparator(sumStr));
    }

    private static boolean checkForNullOrBlank(String sumStr) {
        return sumStr == null || sumStr.isEmpty();
    }

    private static String[] extractNumbersFromSeparator(String separator) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(separator);

        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(customSeparator);
        }

        return separator.split(DEFAULT_SEPARATOR);
    }

    private static int addition(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(s -> validatePositiveInteger(s)).sum();
    }

    private static int validatePositiveInteger(String str) {
        try {
            if (Integer.parseInt(str) < 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new InputMismatchException();
        }
        return Integer.parseInt(str);
    }
}
