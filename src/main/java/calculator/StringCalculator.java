package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SPLIT_REGEX = "[,:]";
    private static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return parseAndSum(tokenizeInput(input)).getValue();
    }

    private static String[] tokenizeInput(String input) {
        Matcher matcher = CUSTOM_SPLIT_PATTERN.matcher(input);
        if (matcher.find()) {
            return splitByCustomPattern(matcher);
        }
        return input.split(SPLIT_REGEX);
    }

    private static String[] splitByCustomPattern(Matcher matcher) {
        return matcher.group(2).split(Pattern.quote(matcher.group(1)));
    }

    private static PositiveNumber parseAndSum(String[] tokens) {
        PositiveNumber sum = new PositiveNumber();
        for (String token : tokens) {
            sum = sum.plus(new PositiveNumber(token));
        }
        return sum;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
