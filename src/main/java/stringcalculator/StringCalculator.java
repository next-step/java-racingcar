package stringcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static stringcalculator.Message.INPUT_BLANK;
import static stringcalculator.Message.INPUT_NULL;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static int calculate(String input) {
        validate(input);
        String[] inputArray = split(input);
        List<Integer> numbers = getNumbers(inputArray);
        List<Operator> operators = getOperators(inputArray);
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            Integer next = numbers.get(i + 1);
            result = operator.operate(result, next);
        }
        return result;
    }

    public static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL);
        }
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_BLANK);
        }
    }

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public static List<Integer> getNumbers(String[] inputArray) {
        return Arrays.stream(inputArray)
                .filter(StringCalculator::isInteger)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static List<Operator> getOperators(String[] inputArray) {
        return Arrays.stream(inputArray)
                .filter(value -> !isInteger(value))
                .map(Operator::operateOf)
                .collect(Collectors.toList());
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ne) {
            return false;
        }
    }
}
