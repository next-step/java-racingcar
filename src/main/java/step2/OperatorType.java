package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

import static step2.common.ArithmethicConstants.*;
import static step2.common.ExceptionMessage.INVALID_OPERATION;

public enum OperatorType {

    ADDITION(OPERATION_ADDITION, (firstVal, secondVal) -> firstVal + secondVal),
    SUBTRACT(OPERATION_SUBTRACT, (firstVal, secondVal) -> firstVal - secondVal),
    MULTIPLY(OPERATION_MULTIPLY, (firstVal, secondVal) -> firstVal * secondVal),
    DIVIDE(OPERATION_DIVIDE, (firstVal, secondVal) -> firstVal / secondVal);

    private final String operationType;
    private BiFunction<Integer, Integer, Integer> expression;

    OperatorType(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operationType = operator;
        this.expression = expression;
    }

    public static int calculate(String operator, int num1, int num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    private static OperatorType getOperator(String operationType){
        return Arrays.stream(values())
                .filter(o -> o.operationType.equals(operationType))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATION));
    }
}
