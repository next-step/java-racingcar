import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    static final String DEFAULT_DELIMITER = ":|,";

    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter));
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] strNumbers) {
        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = toInt(strNumbers[i]);
        }

        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);

        if (number < 0) {
            throw new RuntimeException("음수 값이 전달되었습니다.");
        }

        return number;
    }

}
