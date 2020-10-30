package stringCalculator;


public class InputParser {

    private String input;
    private Operator operator;

    InputParser(String input, Operator operator) {
        this.input = input;
        this.operator = operator;

        checkInputValidity();
    }

    private void checkInputValidity() {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Input is invalid form");
    }

    String[] parseInput() {
        String[] parsedInput = input.split(" ");
        checkParsedInputValidity(parsedInput);

        return parsedInput;
    }

    private void checkParsedInputValidity(String[] parsedInput) {
        checkOperatorValidity(parsedInput);
        checkPair(parsedInput);
    }

    private void checkOperatorValidity(String[] parsedInput) {
        for (int idx = 1; idx < parsedInput.length; idx += 2)
            judgeOperatorValidity(parsedInput[idx]);
    }

    private void judgeOperatorValidity(String input) {
        if (!operator.isValidOperator(input))
            throw new IllegalArgumentException("Invalid operator");
    }

    private void checkPair(String[] parsedInput) {
        if (parsedInput.length % 2 == 0)
            throw new IllegalArgumentException("Input doesn't match pair");
    }

}
