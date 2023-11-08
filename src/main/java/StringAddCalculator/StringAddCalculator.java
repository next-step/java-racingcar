package StringAddCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public static int splitAndSum(Object rawInput) {
        rawInput = convertEmpty(rawInput);
        List<String> inputValues = split((String) rawInput);
        validate(inputValues);
        return caluate(inputValues);
    }

    private static Object convertEmpty(Object rawInput) {
        if (isEmpty(rawInput)) {
            return "0";
        }
        return rawInput;
    }

    private static boolean isEmpty(Object rawInput) {
        return rawInput == null || rawInput.equals("");
    }

    private static List<String> split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] tokens;
        if (m.find()) {
            tokens = splitWithCustom(m);
        }
        else {
            tokens = splitDefault(input);
        }
        return removeBlank(tokens);
    }

    private static String[] splitWithCustom(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(",|:|" + customDelimiter);
    }

    private static String[] splitDefault(String input) {
        return input.split(",|:|");
    }

    private static List<String> removeBlank(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(value -> !value.isEmpty())
                .collect(Collectors.toList());
    }

    private static void validate(List<String> inputSplit) {
        for (String value : inputSplit) {
            validateNumber(value);
            validatePositiveNumber(value);
        }
    }

    private static void validateNumber(String value) {
        if (!isNumber(value)) {
            throw new RuntimeException("숫자로로 입력해주세요");
        }
    }

    private static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
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
        return Integer.parseInt(value);
    }

    private static int caluate(List<String> rawInputValues) {
        List<Integer> inputValues = convertToInt(rawInputValues);
        int sum = 0;
        for (int value : inputValues) {
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
