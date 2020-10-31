package stringCalculator;


public class Calculator {

    private static final int NEXT_OPERATOR_NUMBER_INDEX = 2;
    private static final int INITIAL_VALUE_INDEX = 0;

    private String[] parsedInput;
    private Operator operator;

    private Calculator(String[] parsedInput, Operator operator) {
        this.parsedInput = parsedInput;
        this.operator = operator;
    }

    public static Calculator of(String[] parsedInput, Operator operator) {
        return new Calculator(parsedInput, operator);
    }

    public static Calculator of(String input) {
        Operator operator = Operator.getInstance();
        InputParser inputParser = InputParser.of(input, operator);
        String[] parsedInput = inputParser.parseInput();

        return of(parsedInput, operator);
    }

    int calculate() {
        int result = Integer.parseInt(parsedInput[INITIAL_VALUE_INDEX]);

        for (int idx = 1; idx < parsedInput.length; idx += NEXT_OPERATOR_NUMBER_INDEX) {

            result = operator.calculateWithOperator(result, parsedInput[idx], Integer.parseInt(parsedInput[idx + 1]));

        }

        return result;
    }

}
