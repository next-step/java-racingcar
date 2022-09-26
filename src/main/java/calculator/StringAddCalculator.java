package calculator;

import calculator.operator.NumberOperator;
import calculator.operator.StringOperator;

import static calculator.operator.NumberOperator.parseNumberOperators;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        NumberOperator numberOperator = new NumberOperator(0);
        StringOperator stringOperator = new StringOperator(value);

        if (stringOperator.isNotBlank()) {
            String[] numberArr = stringOperator.split();

            parseNumberOperators(numberArr).forEach(numberOperator::sum);
        }

        return numberOperator.getValue();
    }
}
