package me.devyonghee.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DelimiterFinder {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private final Pattern pattern;

    private DelimiterFinder(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("'pattern' must not be null");
        }
        this.pattern = pattern;
    }

    static DelimiterFinder from(Pattern pattern) {
        return new DelimiterFinder(pattern);
    }

    String delimiter(String target) {
        if (target == null) {
            return DEFAULT_DELIMITER_REGEX;
        }

        Matcher matcher = pattern.matcher(target);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_DELIMITER_REGEX;
    }
}
