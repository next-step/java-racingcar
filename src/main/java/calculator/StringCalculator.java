package calculator;

public class StringCalculator {

    private MathematicalExpression expression;

    public StringCalculator(String value) {
        this.expression = new MathematicalExpression(value);
    }

    public int execute() {
        Integer[] numbers = expression.getNumbers();
        Operator[] operators = expression.getOperators();

        int accumulator = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            accumulator = operators[i].compute(accumulator, numbers[i + 1]);
        }
        return accumulator;
    }
}
