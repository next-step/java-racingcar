package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS('+', Integer::sum),
    MINUS('-', (number1, number2) -> number1 - number2),
    MULTIPLY('*', (number1, number2) -> number1 * number2),
    DIVIDE('/', divideIntBinaryOperator()),
    ;

    private static IntBinaryOperator divideIntBinaryOperator() {
        return (number1, number2) -> {
            if ((number1 / number2) == (number1 / (double) number2)) {
                return number1 / number2;
            }

            throw new ArithmeticException("나눗셈의 결과는 정수이어야 합니다.");
        };
    }

    private static final Map<Character, Operator> operatorCharMap = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            operatorCharMap.put(operator.operatorChar, operator);
        }
    }

    private final Character operatorChar;
    private final IntBinaryOperator operatingExpression;

    Operator(Character operatorChar, IntBinaryOperator operatingExpression) {
        this.operatorChar = operatorChar;
        this.operatingExpression = operatingExpression;
    }

    public static Operator find(String operator) {
        if (operator.length() > 1) {
            throw new IllegalArgumentException("잘못된 연산자");
        }

        return operatorCharMap.get(operator.charAt(0));
    }

    public int calculate(int num1, int num2) {
        return this.operatingExpression.applyAsInt(num1, num2);
    }
}
