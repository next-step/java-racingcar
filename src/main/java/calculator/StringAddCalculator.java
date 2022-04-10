package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.ExceptionCode.NEGATIVE_VALIDATION;

public class StringAddCalculator {

    private static final String REGEX = "//(.)\n(.*)";
    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] splitByDelimiter = matcher.group(2).split(customDelimiter);
            return sum(toInts(splitByDelimiter));
        }

        String[] splitString = text.split(DELIMITER);
        return sum(toInts(splitString));
    }

    private static int sum(int[] ints) {
        int result = 0;
        for (int each : ints) {
            result += each;
        }
        return result;
    }

    private static int[] toInts(String[] strings) {
        int[] ints = new int[strings.length];
        for (int index = 0; index < strings.length; index++) {
            ints[index] = toInt(strings[index]);
        }
        return ints;
    }

    private static int toInt(String each) {
        int integer = Integer.parseInt(each);
        if (integer < 0) {
            throw new IllegalArgumentException(NEGATIVE_VALIDATION.getMessage());
        }
        return integer;
    }
}
