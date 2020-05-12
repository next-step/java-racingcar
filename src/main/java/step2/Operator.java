package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    Operator(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operatorSign = operation;
        this.expression = expression;
    }

    private final String operatorSign;
    private final BiFunction<Integer, Integer, Integer> expression;

    public String getOperatorSign() {
        return operatorSign;
    }

    public int operate(int num1, int num2){
        return expression.apply(num1, num2);
    }

    public static Operator findOperator(String operatorSign) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getOperatorSign().equals(operatorSign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }
}
