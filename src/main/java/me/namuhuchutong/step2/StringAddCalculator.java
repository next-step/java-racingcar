package me.namuhuchutong.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String COMMA_COLONS = "[,:]";


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
        String[] tokens = {};

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(COMMA_COLONS);
        }

        return tokens;
    }

    private static Integer convertStringToInteger(String stringNumber) {
        Integer integer = Integer.valueOf(stringNumber);
        if (isNegativeInteger(integer)) {
            throw new RuntimeException();
        }
        return integer;
    }

    private static boolean isNegativeInteger(Integer integer) {
        return integer.compareTo(0) < 0;
    }
}
