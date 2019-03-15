package calculator_tdd;

public class StringAdder {
    private StringAdder() {
    }

    public static int calculate(String inputExpression) {
        Expression expression = new Expression(inputExpression);

        if (expression.isCustom()) {
            expression = expression.toStandard();
        }

        return sum(expression.toNumbers());
    }

    static int sum(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

}
