import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    private static void checkHasNegativeAndThrow(int[] numbers) {
        List<Integer> negativeNumbers = Arrays.stream(numbers).filter(number -> number < 0)
                .boxed()
                .collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) {
            throw new RuntimeException("음수가 포함되었습니다 : " + negativeNumbers);
        }
    }

    private static int stringToIntAndSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int stringToIntAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int[] numbers = toNumbers(split(input));

        checkHasNegativeAndThrow(numbers);

        return stringToIntAndSum(numbers);
    }
}
