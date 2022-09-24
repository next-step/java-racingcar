import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    final static Pattern CUSTOM_REGEX_PATTERN = Pattern.compile("(//)(.*?)(\n)");
    final static String DEFAULT_REGEX = ",|:|//|\n|";

    public static int splitAndSum(String message) {
        if (isBlank(message)) {
            return 0;
        }

        String[] numberArr = message.split(getRegex(message));

        int sum = 0;

        for (int i = 0; i < numberArr.length; i++) {
            int number = stringToInt(numberArr[i]);

            validateNegative(number);

            sum += number;
        }

        return sum;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int stringToInt(String numberStr) {
        if (!numberStr.isBlank()) {
            int number = Integer.parseInt(numberStr);

            return number;
        }

        return 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String getRegex(String numberString) {
        String regex = DEFAULT_REGEX;

        Matcher matcher = CUSTOM_REGEX_PATTERN.matcher(numberString);

        if (matcher.find()) {
            regex += matcher.group(2).trim();
        }

        return regex;
    }
}
