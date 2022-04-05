package me.devyonghee.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError();
    }

    static int splitAndSum(String target) {
        return stringNumbers(target).positiveSum();
    }

    private static StringNumbers stringNumbers(String target) {
        if (target == null || target.isBlank()) {
            return StringNumbers.empty();
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] strings = m.group(2).split(customDelimiter);
            return StringNumbers.from(strings);
        }
        return StringNumbers.from(target.split(",|:"));
    }
}
