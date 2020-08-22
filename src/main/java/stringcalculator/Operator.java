package stringcalculator;

import calculator.Operation;
import com.sun.tools.internal.jxc.ap.Const;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLE("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException(Constants.DIVIDE_BY_ZERO);
        }
        return first / second;
    });

    private final String operator;
    private final IntBinaryOperator binaryOperator;

    Operator(String operator, IntBinaryOperator binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static Operator getOperator(String value) {
        Optional<Operator> maybeOperator = Arrays.stream(values())
                                                    .filter(op -> op.operator.equals(value))
                                                    .findFirst();
        return maybeOperator.orElseThrow(() -> new IllegalArgumentException(Constants.IS_NOT_VALID_OPERATOR));
    }

    public int operate(int first, int second) {
        return binaryOperator.applyAsInt(first, second);
    }
}
