package me.devyonghee.basic;

import java.util.regex.Pattern;

final class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\n");
    private static final StringSeparator SEPARATOR = StringSeparator.of(
            StringFilter.from(CUSTOM_DELIMITER_PATTERN), DelimiterFinder.from(CUSTOM_DELIMITER_PATTERN));

    private StringAddCalculator() {
        throw new AssertionError();
    }

    static int splitAndSum(String target) {
        return ZeroPositives.from(SEPARATOR.separate(target))
                .sum()
                .number();
    }
}
