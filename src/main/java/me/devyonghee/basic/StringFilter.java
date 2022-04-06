package me.devyonghee.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StringFilter {

    private final Pattern pattern;

    private StringFilter(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("'pattern' must not be null");
        }
        this.pattern = pattern;
    }

    static StringFilter from(Pattern pattern) {
        return new StringFilter(pattern);
    }

    String filter(String target) {
        validateTarget(target);
        Matcher matcher = pattern.matcher(target);
        if (matcher.find()) {
            return matcher.replaceFirst("");
        }
        return target;
    }

    private void validateTarget(String target) {
        if (target == null) {
            throw new IllegalArgumentException("filtered string must not be null");
        }
    }
}
