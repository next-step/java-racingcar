package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS(Integer::sum),
    MINUS((x, y) -> x - y),
    MULTIPLE((x, y) -> x * y),
    DIVIDE((x, y) -> x / y);

    private final BiFunction<Integer, Integer, Integer> operationFunction;

    Operator(BiFunction<Integer, Integer, Integer> operationFunction) {
        this.operationFunction = operationFunction;
    }

    public int calculate(int num1, int num2) {
        return operationFunction.apply(num1, num2);
    }

    public static Operator getOperator(String symbol) {
        switch (symbol) {
            case "+":
                return Operator.PLUS;
            case "-":
                return Operator.MINUS;
            case "*":
                return Operator.MULTIPLE;
            case "/":
                return Operator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}
