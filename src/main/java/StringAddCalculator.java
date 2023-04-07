import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    private static final String EMPTY_STRING = "";

    private static final String BASIC_SEPARATOR = "[,:]";
    private static final int ZERO = 0;

    public static int splitAndSum(String input) {
        if (isInputNullOrEmptyString(input)) {
            return ZERO;
        }
        String customSeparators = addCustomSeparators(input, BASIC_SEPARATOR);
        String trimmedInput = trimInput(input);
        String[] container = trimmedInput.split(customSeparators);

        return Arrays.stream(container)
                     .map(Integer::parseInt)
                     .peek(
                        i -> {
                            if (i < 0) {
                                throw new RuntimeException("음수는 계산할 수 없습니다.");
                            }
                        }
                    )
                    .mapToInt(Integer::intValue)
                    .sum();
    }

    private static boolean isInputNullOrEmptyString(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    private static String trimInput(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\n", startIndex);
        if (endIndex == -1) {
            return input;
        }
        return input.substring(endIndex + 1);
    }

    private static String addCustomSeparators(String input, String separator) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\n", startIndex);
        if (endIndex == -1) {
            return separator;
        }
        String customSeparators = input.substring(startIndex, endIndex);
        StringBuilder separators = new StringBuilder(separator);
        separators.insert(separators.length() - 1, customSeparators);
        return separators.toString();
    }

}
