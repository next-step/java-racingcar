package me.devyonghee.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StringSeparator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int STRING_WITHOUT_CUSTOM_DELIMITER_INDEX = 2;
    private final Pattern customDelimiterPattern;

    private StringSeparator(Pattern customDelimiterPattern) {
        if (customDelimiterPattern == null) {
            throw new IllegalArgumentException("'customDelimiterPattern' must not be null");
        }
        this.customDelimiterPattern = customDelimiterPattern;
    }

    static StringSeparator from(Pattern customDelimiterPattern) {
        return new StringSeparator(customDelimiterPattern);
    }

    List<String> separate(String target) {
        if (target == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(split(target));
    }

    private String[] split(String target) {
        Matcher matcher = customDelimiterPattern.matcher(target);
        if (matcher.find()) {
            return matcher.group(STRING_WITHOUT_CUSTOM_DELIMITER_INDEX)
                    .split(matcher.group(CUSTOM_DELIMITER_INDEX));
        }
        return target.split(DEFAULT_DELIMITER_REGEX);
    }
}
