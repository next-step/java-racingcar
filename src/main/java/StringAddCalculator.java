import java.util.Arrays;
import java.util.List;
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

        return sum(toPositiveInts(split(input)));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        if (hasCustomDelimiter(input)) {
            return splitWithCustomDelimiters(input);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String[] splitWithCustomDelimiters(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITERS_EXTRACT_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> toPositiveInts(String[] tokens) {
        return Arrays.stream(tokens).map(StringAddCalculator::toPositive).toList();
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return number;
    }
}
