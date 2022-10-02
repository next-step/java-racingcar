package calculator;

import calculator.operator.PositiveNumber;
import calculator.operator.MessageOperator;

import static calculator.operator.PositiveNumber.parseNumberOperators;

public class StringAddCalculator {

    public static PositiveNumber splitAndSum(String value) {
        PositiveNumber numberOperator = new PositiveNumber(0);
        MessageOperator messageOperator = new MessageOperator(value);

        if (messageOperator.isNotBlank()) {
            String[] numberArr = messageOperator.split();

            parseNumberOperators(numberArr).forEach(numberOperator::plus);
        }

        return numberOperator;
    }
}
