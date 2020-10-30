package stringCalculator;


public class Calculator {

    private String[] parsedInput;
    private Operator operator;

    Calculator(String[] parsedInput, Operator operator) {
        this.parsedInput = parsedInput;
        this.operator = operator;
    }

    int calculate() {
        int result = Integer.parseInt(parsedInput[0]);

        for (int idx = 1; idx < parsedInput.length; idx += 2)
            result = operator.calculateWithOperator(result, parsedInput[idx], Integer.parseInt(parsedInput[idx + 1]));

        return result;
    }

    static Calculator Of(String input) {
        Operator operator = new Operator();
        InputParser inputParser = new InputParser(input, operator);
        String[] parsedInput = inputParser.parseInput();

        return new Calculator(parsedInput, operator);
    }

}
