package com.nextstep.javaRacing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern singleNumberPattern = Pattern.compile("[-+]?\\d*");
    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] tokens = tokenize(s);
        return parseAndSum(tokens);
    }

    private static String[] tokenize(String s) {
        Matcher matcher = customDelimiterPattern.matcher(s);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String valuePattern = matcher.group(2);
            return valuePattern.split(customDelimiter);
        }
        return s.split("[,:]");
    }

    private static int parseAndSum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            result += parse(token);
        }
        return result;
    }

    private static int parse(String s) {
        if(s.charAt(0)=='-' || !isNumeric(s)){
            throw new IllegalArgumentException("input must be positive number : " + s);
        }
        return Integer.parseInt(s);
    }

    private static boolean isNumeric(String s) {
        Matcher m = singleNumberPattern.matcher(s);
        return m.matches();
    }
}
