package com.next.step.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_DELIMITER = "[,:]";

    private static final int DELIMITER_EXTRACT_NUMBER = 1;

    private static final int INPUT_EXTRACT_NUMBER = 2;

    public static String[] splitInput(String input) {
        Matcher customPatternMatcher = CUSTOM_PATTERN.matcher(input);
        if (customPatternMatcher.find()) {
            String customDelimiter = customPatternMatcher.group(DELIMITER_EXTRACT_NUMBER);
            return customPatternMatcher.group(INPUT_EXTRACT_NUMBER).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
