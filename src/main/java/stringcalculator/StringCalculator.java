package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static stringcalculator.Validator.isInteger;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public int calculate(String input) {
        Validator.validateInput(input);
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

    private String[] split(String input) {
        return input.split(DELIMITER);
    }

    private List<Integer> getNumbers(String[] inputArray) {
        return Arrays.stream(inputArray)
                .filter(Validator::isInteger)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<Operator> getOperators(String[] inputArray) {
        return Arrays.stream(inputArray)
                .filter(value -> !isInteger(value))
                .map(Operator::operateOf)
                .collect(Collectors.toList());
    }
}
