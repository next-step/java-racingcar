package calculator;

import calculator.factory.SplitterFactory;
import calculator.factory.splitter.Splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(SeparatorConst.CUSTOM_SEPARATOR_REGEX_PATTERN).matcher(text);
        SplitterFactory factory = new SplitterFactory();
        Splitter splitter = factory.getSplitter(matcher.find());

        return splitter.split(text)
                .stream()
                .map(number-> new PositiveNumber(number))
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }
}
