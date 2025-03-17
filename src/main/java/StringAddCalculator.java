import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public static int splitAndSum(String text) {
        if(isNullOrBlank(text)) return 0;

        return sum(convertToNumbers(splitByDelimiter(text)));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitByDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String textWithCustomDelimiter = matcher.group(2);
            return textWithCustomDelimiter.split(combineDefaultDelimiterWith(customDelimiter));
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static String combineDefaultDelimiterWith(String customDelimiter) {
        return String.format("%s|%s", DEFAULT_DELIMITER_REGEX, Pattern.quote(customDelimiter));
    }

    private static int[] convertToNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(tokens[i]);
            isPositiveOrThrow(numbers[i]);
        }
        return numbers;
    }

    private static void isPositiveOrThrow(int number) {
        if (number < 0) throw new NumberFormatException();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers) sum += number;
        return sum;
    }
}
