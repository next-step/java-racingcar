package com.nextstep.javaRacing.stringAddCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] tokens = split(s);
        return sum(tokens);
    }

    private static String[] split(String s) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(s);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String valuePattern = matcher.group(2);
            return valuePattern.split(customDelimiter);
        }
        return s.split("[,:]");
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(s->parse(s)).sum();
    }

    private static int parse(String s) {
        if(!isNumeric(s)){
            throw new IllegalArgumentException("input must be positive number : " + s);
        }
        return Integer.parseInt(s);
    }

    private static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}
