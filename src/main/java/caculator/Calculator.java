package caculator;

public class Calculator {
    private final Operator operator = new Operator();
    private final InputProcessor inputProcessor = new InputProcessor();

    public double calculate(final String input) {
        return execute(inputProcessor.processInput(input));
    }

    private double execute(final String[] parsedInput) {
        double result = Double.parseDouble(parsedInput[0]);

        for (int i = 1; i < parsedInput.length; i += 2) {
            result = operator.calculate(result, parsedInput[i], parsedInput[i+1]);
        }
        return result;
    }
}