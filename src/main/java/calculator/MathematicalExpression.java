package calculator;

import java.util.Arrays;
import java.util.Objects;

public class MathematicalExpression {

    private static final String DELIMITER = " ";

    private Integer[] numbers;
    private Operator[] operators;

    public MathematicalExpression(String expression) {
        String[] arguments = splitExpression(expression);
        if (isNotValidExpression(arguments)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXPECTED_ARGUMENT.getMessage());
        }
        this.numbers = filter(arguments, true);
        this.operators = filter(arguments, false);
    }

    private String[] splitExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_OR_NULL_ARGUMENT.getMessage());
        }
        return expression.split(DELIMITER);
    }

    private <T> T[] filter(String[] arguments, boolean needNumber) {
        return (T[]) Arrays.stream(arguments)
                .filter(a -> !(isNumber(a) ^ needNumber))
                .map(a -> needNumber ? Integer.parseInt(a) : Operator.of(a))
                .toArray(size -> {
                    return needNumber ? new Integer[size] : new Operator[size];
                });
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isNotValidExpression(String[] arguments) {
        if (arguments.length % 2 == 0) {
            return true;
        }
        for (int i = 0; i < arguments.length; i += 2) {
            if (!isNumber(arguments[i])) {
                return true;
            }
            if (i != arguments.length - 1 && isNumber(arguments[i + 1])) {
                return true;
            }
        }
        return false;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public Operator[] getOperators() {
        return operators;
    }
}
