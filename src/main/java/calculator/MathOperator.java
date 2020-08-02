package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum MathOperator {

    PLUS("+", (value1, value2) -> value1 + value2),
    SUBTRACT("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> value1 / value2);

    private final String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    MathOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static MathOperator findByMathOperatorCode(String code) {
        return Arrays.stream(MathOperator.values())
                .filter(mathOperator -> mathOperator.getOperator().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산 기호를 찾을 수 없습니다."));
    }

    public static Boolean hasMathOperator(String code) {
         return Arrays.stream(MathOperator.values())
                 .filter(mathOperator -> mathOperator.getOperator().equals(code))
                 .findFirst().isPresent();
    }

    public Integer apply(int param1, int param2) {
        return this.expression.apply(param1, param2);
    }

    public String getOperator() {
        return operator;
    }
}
