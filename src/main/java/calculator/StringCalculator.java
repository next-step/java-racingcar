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
        return parseAndSum(tokenizeInput(input));
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

    private static int parseAndSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += new PositiveNumber(token).getValue();
        }
        return sum;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
