package me.devyonghee.basic;

import java.util.regex.Pattern;

final class StringAddCalculator {

    private static final StringSeparator SEPARATOR = StringSeparator.from(Pattern.compile("//(.)\n(.*)"));

    private StringAddCalculator() {
        throw new AssertionError();
    }

    static int splitAndSum(String target) {
        return ZeroPositives.from(SEPARATOR.separate(target))
                .sum()
                .number();
    }
}
