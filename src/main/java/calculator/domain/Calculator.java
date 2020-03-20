package calculator.domain;

import java.util.Objects;

public class Calculator {
    public int calculate(String expression) {
        validValue(expression);

        String[] value = expression.split(" ");

        int result = Integer.valueOf(value[0]);

        boolean isOperationSymbol = true;

        for (int i = 1; i < value.length - 1; i++) {
            if (isOperationSymbol) {
                result = apply(value[i], result, Integer.valueOf(value[i + 1]));

                isOperationSymbol = false;
                continue;
            }

            isOperationSymbol = true;
        }

        return result;
    }

    public int apply(String symbol, int x, int y) {
        switch (symbol) {
            case "+":
                return Operator.addition(x, y);
            case "-":
                return Operator.subtraction(x, y);
            case "*":
                return Operator.multiplication(x, y);
            case "/":
                return Operator.division(x, y);
            default: {
                throw new IllegalArgumentException(String.format("올바르지 않은 symbol : %s", symbol));
            }
        }
    }

    private void validValue(String value) {
        if(Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("null 혹은 빈 값");
        }
    }
}
