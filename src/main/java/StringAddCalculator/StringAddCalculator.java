package StringAddCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static final Pattern INPUT_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String COMMA = ",";
    public static final String COLUMN = ":";

    public static int splitAndSum(String rawInput) {
        String input = convertEmpty(rawInput);
        List<String> inputValues = split(input);
        validate(inputValues);
        return calculate(convertToInt(inputValues));
    }

    private static String convertEmpty(String rawInput) {
        if (isEmpty(rawInput)) {
            return "0";
        }
        return rawInput;
    }

    private static boolean isEmpty(String rawInput) {
        return Objects.isNull(rawInput) || rawInput.equals("");
    }

    private static List<String> split(String input) {
        Matcher m = INPUT_PATTERN.matcher(input);
        String[] tokens;
        if (m.find()) {
            tokens = splitWithCustom(m);
            return removeBlank(tokens);
        }
        tokens = splitDefault(input);
        return removeBlank(tokens);
    }

    private static String[] splitWithCustom(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(COMMA + "|" + COLUMN + "|" + customDelimiter);
    }

    private static String[] splitDefault(String input) {
        return input.split(COMMA + "|" + COLUMN + "|");
    }

    private static List<String> removeBlank(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(value -> !value.isEmpty())
                .collect(Collectors.toList());
    }

    private static void validate(List<String> inputSplit) {
        for (String value : inputSplit) {
            validatePositiveNumber(value);
        }
    }

    private static void validatePositiveNumber(String value) {
        if (!isPositiveNumber(value)) {
            throw new RuntimeException("음수가 아닌 수로 입력해주세요");
        }
    }

    private static boolean isPositiveNumber(String value) {
        return convertToInt(value) >= 0;
    }

    private static int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자로 입력해주세요");
        }
    }


    private static int calculate(List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static List<Integer> convertToInt(List<String> inputSplit) {
        return inputSplit.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
