package me.devyonghee.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class StringSeparator {

    private final StringFilter stringFilter;
    private final DelimiterFinder delimiterFinder;

    private StringSeparator(StringFilter stringFilter, DelimiterFinder delimiterFinder) {
        validateNull(stringFilter, "'stringFilter' must not be null");
        validateNull(delimiterFinder, "'delimiterFinder' must not be null");
        this.stringFilter = stringFilter;
        this.delimiterFinder = delimiterFinder;
    }

    static StringSeparator of(StringFilter stringFilter, DelimiterFinder delimiterFinder) {
        return new StringSeparator(stringFilter, delimiterFinder);
    }

    List<String> separate(String target) {
        if (target == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(split(target));
    }

    private void validateNull(Object argument, String message) {
        if (argument == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private String[] split(String target) {
        return stringFilter.filter(target)
                .split(delimiterFinder.delimiter(target));
    }
}
