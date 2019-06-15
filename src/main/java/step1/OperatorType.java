package step1;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", (op1, op2) -> op1 + op2),
    SUB("-", (op1, op2) -> op1 - op2),
    MUL("*", (op1, op2) -> op1 * op2),
    DIV("/", (op1, op2) -> op1 / op2);

    private final String operatorName;
    private final BiFunction<Integer, Integer, Integer> calculateExpression;

    OperatorType(String operatorName, BiFunction<Integer, Integer, Integer> calculateExpression) {
        this.operatorName = operatorName;
        this.calculateExpression = calculateExpression;
    }

    public static OperatorType findByOperatorName(final String operatorName) {
        return Arrays.stream(OperatorType.values())
                     .filter(operator -> operator.operatorName.equals(operatorName))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다. 사용 가능한 기호 [" + Arrays.toString(OperatorType.values()) + "], 잘못 입력한 기호 : " + operatorName));
    }

    public int calculate(final int operand1, final int operand2) {
        return calculateExpression.apply(operand1, operand2);
    }
}
