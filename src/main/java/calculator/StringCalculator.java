package calculator;

import java.util.function.BiFunction;

public class StringCalculator {
    public static int calculate(String expression) {
        validateInput(expression);
        String[] splitExpression = expression.split(" ");

        int result = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i += 2) {
            BiFunction<Integer, Integer, Integer> calculateFunction = distinguishOperator(splitExpression[i]);
            int operand = Integer.parseInt(splitExpression[i + 1]);

            result = calculateFunction.apply(result, operand);
        }

        return result;
    }

    private static void validateInput(String expression) {
        if(expression==null || expression.isEmpty())
            throw new IllegalArgumentException("입력은 공백이면 안됩니다.");
    }

    private static BiFunction<Integer, Integer, Integer> distinguishOperator(String operator) {
        if (operator.equals("+"))
            return add();
        if(operator.equals("-"))
            return subtract();
        if(operator.equals("*"))
            return multiply();
        return divide();
    }

    private static BiFunction<Integer, Integer, Integer> add() {
        return (a, b) -> a + b;
    }

    private static BiFunction<Integer, Integer, Integer> subtract() {
        return (a, b) -> a - b;
    }

    private static BiFunction<Integer, Integer, Integer> multiply() {
        return (a, b) -> a * b;
    }

    private static BiFunction<Integer, Integer, Integer> divide() {
        return (a, b) -> a / b;
    }

}
