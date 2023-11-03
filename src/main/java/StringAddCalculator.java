import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_NUMBER = 0;

    private static final String DELIMITER = "[,:]";

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_NUMBER;
        }

        return sum(toNumbers(split(text)));
    }

    private static int[] toNumbers(String[] split) {
        int[] numbers = new int[split.length];

        for (int idx = 0; idx < split.length; idx++) {
            int number = Integer.parseInt(split[idx]);
            checkIsNegative(number);
            numbers[idx] = number;
        }

        return numbers;
    }

    private static String[] split(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);

            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static void checkIsNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number: numbers) {
            sum += number;
        }

        return sum;
    }
}
