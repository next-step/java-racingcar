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
            return matcher.group(2).split(Pattern.quote(matcher.group(1)));
        }

        return input.split(SPLIT_REGEX);
    }

    private static int parseAndSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += toNumber(token);
        }
        return sum;
    }

    private static int toNumber(String token) {
        int number = parseInt(token);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
