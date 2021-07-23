package calculator;

import java.util.function.BiFunction;

public class StringCalculator {
    public static int calculate(String expression) {
        String[] splitExpression = expression.split(" ");

        int result = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i += 2) {
            BiFunction<Integer, Integer, Integer> calculateFunction = distinguishOperator(splitExpression[i]);
            int operand = Integer.parseInt(splitExpression[i + 1]);

            result = calculateFunction.apply(result, operand);
        }

        return result;
    }

    public static BiFunction<Integer, Integer, Integer> distinguishOperator(String operator) {
        if (operator.equals("+"))
            return add();
        if(operator.equals("-"))
            return subtract();
        if(operator.equals("*"))
            return multiply();
        return divide();
    }

    public static BiFunction<Integer, Integer, Integer> add() {
        return (a, b) -> a + b;
    }

    public static BiFunction<Integer, Integer, Integer> subtract() {
        return (a, b) -> a - b;
    }

    public static BiFunction<Integer, Integer, Integer> multiply() {
        return (a, b) -> a * b;
    }

    public static BiFunction<Integer, Integer, Integer> divide() {
        return (a, b) -> a / b;
    }

}
