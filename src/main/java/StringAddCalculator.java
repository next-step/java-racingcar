import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(isNullOrBlank(text)) return 0;

        return sum(convertToNumbers(splitByDelimiter(text)));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitByDelimiter(String text) {
        final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
        final String DEFAULT_DELIMITER_REGEX = ",|:";

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(String.join("|", DEFAULT_DELIMITER_REGEX, customDelimiter));
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
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
