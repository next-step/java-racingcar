import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        int[] numbers = stringToNumbers(text);
        checkHasNegative(numbers);

        return Arrays.stream(numbers).sum();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] stringToNumbers(String text) {
        Matcher m = pattern.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);

            return Arrays.stream(m.group(2).split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return Arrays.stream(text.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void checkHasNegative(int[] numbers) {
        boolean hasNegative = Arrays.stream(numbers).anyMatch(a -> a < 0);

        if (hasNegative) {
            throw new RuntimeException();
        }
    }
}
