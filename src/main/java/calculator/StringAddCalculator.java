package calculator;

import calculator.operator.NumberOperator;
import calculator.operator.StringOperator;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        NumberOperator numberOperator = new NumberOperator(0);
        StringOperator stringOperator = new StringOperator(value);

        if (stringOperator.isNotBlank()) {
            String[] numberArr = stringOperator.split();

            numberOperator.parseNumberOperators(numberArr).forEach(numberOperator::sum);
        }

        return numberOperator.getValue();
    }
}
