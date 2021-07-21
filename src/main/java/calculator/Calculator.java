package calculator;

public class Calculator {

    private static final String INPUT_STRING_DELIMITER = " ";
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 2;
    private static final int OPERATOR_INDEX = 1;

    public int calculate(String input) {
        validate(input);
        String[] splitInput = input.split(INPUT_STRING_DELIMITER);
        int first = toInteger(splitInput[FIRST_NUMBER_INDEX]);
        int second = toInteger(splitInput[SECOND_NUMBER_INDEX]);
        Operator operator = Operator.of(splitInput[OPERATOR_INDEX]);
        return operator.operate(first, second);
    }

    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(String.format("입력 값이 유효하지 않습니다. %s", input));
        }
    }

    private int toInteger(String numberString) {
        return Integer.parseInt(numberString);
    }
}
