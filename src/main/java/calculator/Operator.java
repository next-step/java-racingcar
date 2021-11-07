package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", MyNumber::add),
    SUBTRACTION("-", MyNumber::subtraction),
    MULTIPLICATION("*", MyNumber::multiplication),
    DIVISION("/", MyNumber::division);

    private final String value;
    private final BiFunction<MyNumber, MyNumber, MyNumber> operateFunction;

    Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operateFunction) {
        this.operateFunction = operateFunction;
        this.value = operator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.value.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid operator : " + operator));
    }

    public MyNumber operate(MyNumber first, MyNumber second) {
        return this.operateFunction.apply(first, second);
    }
}
