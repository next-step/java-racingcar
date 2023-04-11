package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {

    private static final int CUSTOM_DELIMITER_START = 2;
    private static final int CUSTOM_DELIMITER_END = 3;
    private static final String CUSTOM_DELIMITER_PATTERN = "₩₩(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final int LEAST_LENGTH_OF_CUSTOM_DELIMITER = 4;

    static String extractNumberString(String input, String delimiter) {
        if (DEFAULT_DELIMITER_PATTERN.contains(delimiter)) {
            return input;
        }
        return input.substring(LEAST_LENGTH_OF_CUSTOM_DELIMITER);
    }

    static Operand extractDelimiter(Operand operand) {

        if (operand.input.length() < LEAST_LENGTH_OF_CUSTOM_DELIMITER)
            operand.delimiter = DEFAULT_DELIMITER_PATTERN;

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(operand.input);
        operand.delimiter = m.find() ? extractCustomDelimiter(operand.input) : DEFAULT_DELIMITER_PATTERN;

        return operand;
    }

    static String extractCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START, CUSTOM_DELIMITER_END);
    }

    static Operand extractNumbers(Operand operand) {


        String stringPart = extractNumberString(operand.input, operand.delimiter);
        operand.stringNumbers = stringPart.split(operand.delimiter);
        hasOnlyPositive(operand);
        operand.numbers = Stream.of(operand.stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        return operand;
    }

    static boolean hasOnlyPositive(Operand operand) { // 음수 또는 숫자 이외의 값을 포함하는지
        for (String number : operand.stringNumbers) {
            isNegative(number);
        }
        return true;
    }

    static void isNegative(String input) throws RuntimeException {
        if (parseInt(input) < 0) {
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
