package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLONS = ":";
    private static final String CUSTOM_DELIMITER_PATTERN = "₩₩(.)\n(.*)";
    private static final int LEAST_LENGTH_OF_CUSTOM_DELIMITER = 4;

    static boolean hasCustomDelimiter(String input) {

        if (input.length() < LEAST_LENGTH_OF_CUSTOM_DELIMITER) return false;
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        return m.find();
    }

    static String extractCustomDelimiter(String input) {
        return input.substring(2, 3);
    }

    static String extractGeneralDelimiter(String input) {
        return input.contains(COMMA) ? COMMA : COLONS;
    }

    static int[] extractNumbers(String input, String delimiter) {
        String[] stringPart = input.split(delimiter);
        return Stream.of(stringPart)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static boolean hasOnlyPositive(String[] input) { // 음수 또는 숫자 이외의 값을 포함하는지

        for (String s : input) {
            isNegative(s);
        }
        return true;
    }

    static void isNegative(String s) throws RuntimeException {
        if (parseInt(s) < 0) {
            throw new RuntimeException();
        }
    }

    static int sumOfNumbers(int[] input) { // 합

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return sum;
    }

    static boolean isNullOrEmpty(String input) { // null 이나 빈문자열이라면 0 리턴
        return (input == null) || (input.isBlank());
    }
}
