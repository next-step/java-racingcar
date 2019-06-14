package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.provider.OperatorProvider;
import com.jaeyeonling.calculator.type.Operator;

public class StringCalculator {

    private static final OperatorProvider operatorProvider = new OperatorProvider();

    public int calculate(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] splitInput = input.split(" ");

        int result = Integer.valueOf(splitInput[0]);
        for (int i = 1; i < splitInput.length; i += 2) {
            final Operator operator = operatorProvider.symbol(splitInput[i]);

            final int number = Integer.valueOf(splitInput[i + 1]);

            result = operator.apply(result, number);
        }

        return result;
    }
}
