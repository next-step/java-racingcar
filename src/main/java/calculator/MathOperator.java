package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum MathOperator {

    PLUS("+", (value1, value2) -> value1 + value2),
    SUBTRACT("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> {
        if(value2 == 0) {
            throw new IllegalArgumentException("0 으로 나누기는 불가능 합니다.");
        }
        return value1 / value2;
    });

    private final String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    MathOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    /*public static MathOperator findByMathOperatorCode(String code) {
        return Arrays.stream(MathOperator.values())
                .filter(mathOperator -> mathOperator.getOperator().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산 기호를 찾을 수 없습니다."));
    }

    public static Boolean hasMathOperator(String code) {
         return Arrays.stream(MathOperator.values())
                 .filter(mathOperator -> mathOperator.getOperator().equals(code))
                 .findFirst().isPresent();
    }*/

    public static int operate(String operatorCode, int x, int y) {
        return Arrays
                .stream(values())
                .filter(mathOperator -> mathOperator.getOperator().equals(operatorCode))
                .mapToInt(filtered-> filtered.getOperation().apply(x, y))
                .findFirst()
                .orElse(0);
    }

    public String getOperator() {
        return operator;
    }

    private BiFunction<Integer, Integer, Integer> getOperation() {
        return expression;
    }
}
