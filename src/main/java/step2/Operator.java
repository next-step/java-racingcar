package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", Operator::plus),
    SUBTRACTION("-", Operator::minus),
    MULTIPLICATION("*", Operator::multiply),
    DIVISION("/", Operator::divide);

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

    public static MyNumber plus(MyNumber first, MyNumber second) {
        return new MyNumber(first.number + second.number);
    }

    public static MyNumber minus(MyNumber first, MyNumber second) {
        return new MyNumber(first.number - second.number);
    }

    public static MyNumber multiply(MyNumber first, MyNumber second) {
        return new MyNumber(first.number * second.number);
    }

    public static MyNumber divide(MyNumber first, MyNumber second) {
        return new MyNumber(first.number / second.number);
    }
}
