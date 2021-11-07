package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum MyOperator {
    ADDITION("+", (first, second) -> first.plus(second)),
    SUBTRACTION("-", (first, second) -> first.minus(second)),
    MULTIPLICATION("*", (first, second) -> first.times(second)),
    DIVISION("/", (first, second) -> first.dividedBy(second));

    public String operator;
    public BiFunction<MyNumber, MyNumber, MyNumber> operation;

    MyOperator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation){
        this.operator = operator;
        this.operation = operation;
    }

    public MyNumber operate(MyNumber first, MyNumber second){
        return operation.apply(first, second);
    }

    public static MyOperator operator(String Operator) {
        return Arrays.stream(values())
            .filter(o -> o.operator.equals(Operator))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException(String.format("사칙연산 기호가 아닙니다.")));
    }
}
