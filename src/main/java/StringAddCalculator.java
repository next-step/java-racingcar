import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String ALTERNATION_OPERATOR = "|";

    public int splitAndSum(String input) {
        if (input == null || input.isBlank()) return 0;
        return calculate(input);
    }

    private int calculate(String input) {
        String cleanedInput = removeCustomDelimiterSyntax(input);
        List<String> delimiters = getDelimiters(input);
        List<Integer> numbers = parseToIntList(splitByDelimiters(cleanedInput, delimiters));
        return sum(numbers);
    }

    private String removeCustomDelimiterSyntax(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).replaceFirst("$2");
    }

    private List<String> getDelimiters(String input) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    private String[] splitByDelimiters(String input, List<String> delimiters) {
        String regex = String.join(ALTERNATION_OPERATOR, delimiters);
        return input.split(regex);
    }

    private List<Integer> parseToIntList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(this::validatePositiveNumber)
                .collect(Collectors.toList());
    }

    private void validatePositiveNumber(int num) {
        if (num < 0) throw new RuntimeException("음의 정수는 요구 사항에 없습니다.");
    }

    private int sum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}
