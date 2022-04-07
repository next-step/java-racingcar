package calculator;

import calculator.factory.SplitterFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        boolean custom = checkSplitterType(text);
        return new SplitterFactory().getSplitter(custom)
                .split(text)
                .stream()
                .map(number-> new PositiveNumber(number))
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean checkSplitterType(String text) {
        Matcher matcher = Pattern.compile(SeparatorConst.CUSTOM_SEPARATOR_REGEX_PATTERN).matcher(text);
        return matcher.find();
    }
}
