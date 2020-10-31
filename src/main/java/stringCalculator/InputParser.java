package stringCalculator;


import calculatorException.IllegalExpresion;
import calculatorException.IllegalOperatorSymbol;

public class InputParser {

    private String input;
    private Operator operator;

    private InputParser(String input, Operator operator) {
        this.input = input;
        this.operator = operator;
    }

    static public InputParser of(String input) {
        validateInput(input);
        Operator operator = new Operator();

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
        for (int idx = 1; idx < parsedInput.length; idx += 2)
            validateSymbol(parsedInput[idx]);
    }

    private void validateSymbol(String symbol) {
        if (!operator.isValidOperator(symbol))
            throw new IllegalOperatorSymbol();
    }

    private void validateExpresion(String[] parsedInput) {
        if (parsedInput.length % 2 == 0)
            throw new IllegalExpresion();
    }

}
