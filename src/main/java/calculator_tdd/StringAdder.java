package calculator_tdd;

import org.apache.commons.lang3.StringUtils;

public class StringAdder {
    private StringAdder() {
    }

    public static int calculate(String inputExpression) {
        if (StringUtils.isBlank(inputExpression)) {
            return 0;
        }

        Expression expression = new Expression(inputExpression).toStandard();

        return sum(expression.toInts());
    }

    static int sum(int[] ints) {
        int sum = 0;

        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }

        return sum;
    }
}
