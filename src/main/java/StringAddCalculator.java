import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATE_STRING = "[,:]";
    private static final Pattern CUSTOM_SEPARATE_REGEX_CHECKER = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER = 1;
    private static final int NUMBER_TOKENS = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        int[] separateResult = separateInputToIntArray(input);

        negativeValidator(separateResult);

        return Arrays
                .stream(separateResult)
                .sum();
    }

    private static void negativeValidator(int[] targets) {
        if (hasNegative(targets)) {
            throw new RuntimeException();
        }
    }

    private static boolean hasNegative(int[] separateResult) {
        return Arrays.stream(separateResult)
                .anyMatch(eachNumber -> eachNumber < 0);
    }

    private static int[] separateInputToIntArray(String input) {
        Matcher matcher = separateByRegex(input);
        if (matcher.find()) {
            return Arrays.stream(matcher.group(NUMBER_TOKENS)
                            .split(matcher.group(CUSTOM_DELIMITER)))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return Arrays.stream(input
                        .split(SEPARATE_STRING))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static Matcher separateByRegex(String input) {
        return CUSTOM_SEPARATE_REGEX_CHECKER.matcher(input);
    }
}
