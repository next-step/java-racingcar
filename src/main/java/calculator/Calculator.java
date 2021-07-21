package calculator;

public class Calculator {

    public static final String INPUT_STRING_DELIMITER = " ";
    public static final int FIRST_NUMBER_INDEX = 0;
    public static final int SECOND_NUMBER_INDEX = 2;
    public static final int OPERATOR_INDEX = 1;

    public int calculate(String input) {
        String[] splitInput = input.split(INPUT_STRING_DELIMITER);
        int first = toInteger(splitInput[FIRST_NUMBER_INDEX]);
        int second = toInteger(splitInput[SECOND_NUMBER_INDEX]);
        Operator operator = Operator.of(splitInput[OPERATOR_INDEX]);
        return operator.operate(first, second);
    }

    private int toInteger(String numberString) {
        return Integer.parseInt(numberString);
    }
}
