package stringCalculator;


public class Calculator {

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
        Operator operator = new Operator();
        InputParser inputParser = InputParser.of(input, operator);
        String[] parsedInput = inputParser.parseInput();

        return of(parsedInput, operator);
    }

    int calculate() {
        int result = Integer.parseInt(parsedInput[0]);

        for (int idx = 1; idx < parsedInput.length; idx += 2)
            result = operator.calculateWithOperator(result, parsedInput[idx], Integer.parseInt(parsedInput[idx + 1]));

        return result;
    }

}
