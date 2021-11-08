package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", MyNumber::plus),
    SUBTRACTION("-", MyNumber::minus),
    MULTIPLICATION("*", MyNumber::multiply),
    DIVISION("/", MyNumber::divide);

    public static final String VALID_REQUIRED_ARITHMETIC_MSG = "사칙연산 기호가 아닙니다.";
    private String operator;
    private BiFunction<MyNumber, MyNumber, MyNumber> operation;

    Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public MyNumber operate(MyNumber first, MyNumber second) {
        return operation.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values()).filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(VALID_REQUIRED_ARITHMETIC_MSG));
    }

}
