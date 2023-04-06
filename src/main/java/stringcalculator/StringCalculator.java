package stringcalculator;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^(/{2}.\\n).*");
    private static final String NUMBER_REGEX = "\\d";
    private static final String COMMA = ",";
    private static final String COLON = ":";

    private static final String BLANK_STRING = " ";
    private static final String PLUS = "+";
    private static final String PLUS_ESCAPE = "\\+";

    private final Set<String> delimiters = new HashSet<>();
    private final List<String> numbers = new ArrayList<>();
    private final String text;

    public StringCalculator(String text) {
        this.text = text;
        initializeDelimiters();
        validateDelimiter();
        parseNumbers();
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void initializeDelimiters() {
        delimiters.add(COMMA);
        delimiters.add(COLON);
    }

    private void validateDelimiter() {
        if (containsCustomDelimiter(text)) {
            final String customDelimiter = String.valueOf(text.charAt(2));
            delimiters.add(customDelimiter);
        }
        if (containsNotAnyDelimiters(text)) {
            throw new IllegalArgumentException("구분자가 포함되어 있지 않습니다.");
        }
    }

    private boolean containsCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text)
                .find();
    }

    private boolean containsNotAnyDelimiters(String text) {
        return delimiters.stream()
                .noneMatch(text::contains);
    }

    private void parseNumbers() {
        String result = text;
        if (containsCustomDelimiter(text)) {
            result = text.split(System.lineSeparator())[1];
        }
        for (String delimiter : delimiters) {
            switch (delimiter) {
                case PLUS:
                    result = result.replaceAll(PLUS_ESCAPE, BLANK_STRING);
                    break;
                case "{":
                    result = result.replaceAll("\\{", BLANK_STRING);
                    break;
                case "(":
                    result = result.replaceAll("\\(", BLANK_STRING);
                    break;
                case ")":
                    result = result.replaceAll("\\)", BLANK_STRING);
                    break;
                case "[":
                    result = result.replaceAll("\\[", BLANK_STRING);
                    break;
                default:
                    result = result.replaceAll(delimiter, BLANK_STRING);
                    break;
            }
        }

        final List<String> numbers = Arrays.stream(result.split(BLANK_STRING)).collect(Collectors.toList());
        if (notParsable(numbers)) {
            throw new IllegalArgumentException("구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.");
        }

        this.numbers.addAll(numbers);
    }

    private boolean parsable(List<String> numbers) {
        return numbers.stream()
                .allMatch(e -> e.matches(NUMBER_REGEX));
    }

    private boolean notParsable(List<String> numbers) {
        return !parsable(numbers);
    }
}
