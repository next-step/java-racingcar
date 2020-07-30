package calculator;

import resource.StringResources;

import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVISION((a, b) -> {
        if (b == 0) {
            throw new ArithmeticException(StringResources.ERR_DIVIDED_BY_ZERO);
        }
        return a / b;
    });

    private final IntBinaryOperator intBinaryOperator;

    Operator(IntBinaryOperator intBinaryOperator) {
        this.intBinaryOperator = intBinaryOperator;
    }

    public static Operator of(String param) throws IllegalArgumentException {

        char op = param.charAt(0);

        switch (op) {
            case '+':
                return Operator.PLUS;
            case '-':
                return Operator.SUBTRACT;
            case '*':
                return Operator.MULTIPLY;
            case '/':
                return Operator.DIVISION;
        }

        throw new IllegalArgumentException(StringResources.ERR_INCORRECT_OPERATOR);
    }

    public int calculate(int a, int b) throws ArithmeticException {
        return intBinaryOperator.applyAsInt(a, b);
    }
}