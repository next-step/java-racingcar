import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    private static final String DEFAULT_DELEMETER = "[,:]";
    private static final String CUSTOM_DELEMETER = "//(.)\n(.*)";
    private static final Pattern PATTERN_CUSTOM_DELEMETER = Pattern.compile(CUSTOM_DELEMETER);
    private static final int INDEX_CUSTOM_DELEMETER = 1;
    private static final int INDEX_TEXT = 2;


    private static String[] split(String input) {
        Matcher m = PATTERN_CUSTOM_DELEMETER.matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(INDEX_CUSTOM_DELEMETER);
            return m.group(INDEX_TEXT).split(customDelimiter);
        }

        return input.split(DEFAULT_DELEMETER);
    }

    private static int[] toNumbers(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean hasNegative(int[] numbers) {
        return Arrays.stream(numbers).anyMatch(number -> number < 0);
    }

    private static int stringToIntAndSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int stringToIntAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = split(input);

        int[] numbers = toNumbers(tokens);

        if (hasNegative(numbers)) throw new RuntimeException("음수가 존재합니다.");

        return stringToIntAndSum(numbers);
    }
}
