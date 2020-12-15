package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import static calculator.Exception.*;

public enum Operation {
    PLUS("+", Integer::sum),
    MINUS("-", (firstValue, secondValue) -> firstValue - secondValue),
    MULTIPLY("*", (firstValue, secondValue) -> firstValue * secondValue),
    DIVISION("/", (firstValue, secondValue) -> firstValue / secondValue);

    private final String arithmeticOperation;
    private final IntBinaryOperator intBinaryOperator;

    Operation(String arithmeticOperation, IntBinaryOperator intBinaryOperator) {
        this.arithmeticOperation = arithmeticOperation;
        this.intBinaryOperator = intBinaryOperator;
    }

    protected int operation(int left, int right) {
        return intBinaryOperator.applyAsInt(left, right);
    }

    protected static Operation arithmeticOperationCheck(String arithmeticOperation) {
        return Arrays.stream(values())
                .filter(o -> o.arithmeticOperation.equals(arithmeticOperation))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

}
