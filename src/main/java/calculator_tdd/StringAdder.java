package calculator_tdd;

import org.apache.commons.lang3.StringUtils;

public class StringAdder {
    private StringAdder() {
    }

    public static int calculate(String inputExpression) {
        if (StringUtils.isBlank(inputExpression)) {
            return 0;
        }

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
