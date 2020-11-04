package stringCalculator;


import stringCalculator.calculatorException.IllegalExpresion;
import stringCalculator.calculatorException.IllegalOperatorSymbol;

public class InputParser {

    private static final int NEXT_OPERATOR_INDEX = 2;
    private static final int FIRST_OPERATOR_LOCATION = 1;
    private static final int EVEN = 0;

    private String input;
    private Operator operator;

    private InputParser(String input, Operator operator) {
        this.input = input;
        this.operator = operator;
    }

    static public InputParser of(String input) {
        validateInput(input);
        Operator operator = Operator.getInstance();

        return of(input, operator);
    }

    static public InputParser of(String input, Operator operator) {
        return new InputParser(input, operator);
    }

    static private void validateInput(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();
    }

    String[] parseInput() {
        String[] parsedInput = input.split(" ");
        validateParsedInput(parsedInput);

        return parsedInput;
    }

    private void validateParsedInput(String[] parsedInput) {
        validateOperator(parsedInput);
        validateExpresion(parsedInput);
    }

    private void validateOperator(String[] parsedInput) {
        for (int idx = FIRST_OPERATOR_LOCATION; idx < parsedInput.length; idx += NEXT_OPERATOR_INDEX) {
            validateSymbol(parsedInput[idx]);
        }
    }

    private void validateSymbol(String symbol) {
        if (!operator.isValidOperator(symbol))
            throw new IllegalOperatorSymbol();
    }

    private void validateExpresion(String[] parsedInput) {
        if (parsedInput.length % 2 == EVEN)
            throw new IllegalExpresion();
    }

}
