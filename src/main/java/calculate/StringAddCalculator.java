package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {
    private static final String COMMA = ",";
    private static final String COLONS = ":";
    private static final String CUSTOM_DELIMITER_PATTERN = "₩₩(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final int LEAST_LENGTH_OF_CUSTOM_DELIMITER = 4;

    static String extractNumberString(String input, String delimiter) {
        if (DEFAULT_DELIMITER_PATTERN.contains(delimiter)) {
            return input;
        }
        return input.substring(4);
    }

    static String extractDelimiter(String input) {

        if (input.length() < LEAST_LENGTH_OF_CUSTOM_DELIMITER)
            return DEFAULT_DELIMITER_PATTERN;

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        return m.find() ? extractCustomDelimiter(input) : extractGeneralDelimiter(input);
    }

    static String extractCustomDelimiter(String input) {
        return input.substring(2, 3);
    }

    static String extractGeneralDelimiter(String input) {
        return input.contains(COMMA) ? COMMA : COLONS;
    }

    static Operand extractNumbers(Operand operand) {

        System.out.println("operand.input" + operand.input +  "operand.delimiter = "+ operand.delimiter);
        String stringPart = extractNumberString(operand.input, operand.delimiter);

        operand.stringNumbers = stringPart.split(operand.delimiter);

        operand.numbers = Stream.of(operand.stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        return operand;
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

    static Operand sumOfNumbers(Operand operand) { // 합

        int sum = 0;
        for (int i = 0; i < operand.numbers.length; i++) {
            sum += operand.numbers[i];
        }
        operand.sum = sum;
        return operand;
    }

    static boolean isNullOrEmpty(Operand operand) { // null 이나 빈문자열이라면 0 리턴
        return (operand == null) || (operand.input.isBlank());
    }
}
