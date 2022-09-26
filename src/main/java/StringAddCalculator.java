import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        int[] numbers = toInts(toTokens(text));
        checkNegative(numbers);
        return sum(numbers);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] toTokens(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    private static int[] toInts(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
    private static void checkNegative(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new RuntimeException("음수는 포함될 수 없습니다.");
            }
        }
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
