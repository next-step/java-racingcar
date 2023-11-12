import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (hasNullOrEmpty(text)) { return 0; }
        String[] numbers = splitTextToNumbers(text);
        return sum(numbers);
    }

    private static boolean hasNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitTextToNumbers(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(TEXT_GROUP).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            checkNegative(num);
            result += num;
        }
        return result;
    }

    private static int checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("Input number is %d, Input number must be positive", number));
        }
        return number;
    }
}
