package caculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculation {

    public static final String DELIMITERS = ",:";
    public static final String CUSTOM_DELIMITER_REGEX = "^//(.+?)\\n";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return getSum(splitStrings(input));
    }

    private static String[] splitStrings(String input) {
        String delimiters = makeDelimiters(input);
        return getPureInput(input).split(delimiters);
    }

    private static String makeDelimiters(String input) {
        return "[" + DELIMITERS + extractCustomDelimiter(input) + "]";
    }

    private static String extractCustomDelimiter(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private static String getPureInput(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }
        return input;
    }

    private static Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        return pattern.matcher(input);
    }

    private static int getSum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += convertToNumber(value);
        }
        return sum;
    }

    private static int convertToNumber(String value) {
        try {
            int number = Integer.parseInt(value);
            checkNumberCondition(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private static void checkNumberCondition(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
