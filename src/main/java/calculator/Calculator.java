package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    public static final String INVALID_INPUT_EXCEPTION = "문자열 계산기에 숫자 이외의 값 또는 음수가 전달 될 수 없습니다.";

    public static int sum(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (isCustomizedInput(input)) {
            return customizedAdd(input);
        }

        return add(input);
    }

    private static boolean isCustomizedInput(String input) {
        return input.matches("//(.)+\\\\n+(.*)");
    }

    private static int customizedAdd(String input) {
        validateCustomizedInput(input);
        return parseCustomizedInput(input).stream().mapToInt(e -> e).sum();
    }

    private static List<Integer> parseCustomizedInput(String input) {
        Matcher matcher = Pattern.compile("\\/\\/(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return stringArrayToList(tokens);
        }
        return List.of();
    }

    private static void validateCustomizedInput(String input) {
        char customDelimiter = input.charAt(2);
        String parsedInput = input.substring(5);
        if (!parsedInput.matches("\\d*[,|:|" + customDelimiter + "\\d]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    private static int add(String input) {
        validateInput(input);
        return parseInput(input).stream().mapToInt(e -> e).sum();
    }

    private static void validateInput(String input) throws IllegalArgumentException {
        if (!input.matches("\\d*[,|:\\d]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    private static List<Integer> parseInput(String input) {
        return stringArrayToList(input.split(",|:"));
    }

    private static List<Integer> stringArrayToList(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
