import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열로 된 숫자들을 특정 구분자로 분리하여 합산하는 기능을 제공합니다.
 * 기본 구분자는 컴마(,)와 콜론(:)이며, 커스텀 구분자도 지원합니다.
 * 음수 입력값에 대해서는 예외를 발생시킵니다.
 */
public class StringAddCalculator {
    private static final String CUSTOM_DELIMITERS_EXTRACT_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return calcWithDelimiter(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int calcWithDefaultDelimiters(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITERS);
        return sum(tokens);
    }

    private static int calcWithCustomDelimiters(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITERS_EXTRACT_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }

    private static int calcWithDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            return calcWithCustomDelimiters(input);
        }
        return calcWithDefaultDelimiters(input);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .map(StringAddCalculator::validateInt)
                .sum();
    }

    private static int validateInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 입력값은 허용되지 않습니다.");
        }
        return number;
    }
}
