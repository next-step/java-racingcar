package setp2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", BigInteger::add),
    SUBTRACT("-", BigInteger::subtract),
    MULTIPLY("*", BigInteger::multiply),
    DIVIDE("/", BigInteger::divide);

    private final String operator;
    private final BiFunction<BigInteger, BigInteger, BigInteger> expression;

    Operator(String operator, BiFunction<BigInteger, BigInteger, BigInteger> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static BigInteger calculate(int num1,
                                       String operator,
                                       int num2) {
        return get(operator).expression.apply(BigInteger.valueOf(num1),
                                              BigInteger.valueOf(num2));
    }

    private static Operator get(String operator) {
        return Arrays.stream(values())
                     .filter(o -> o.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("연산자 확인이 필요합니다. : "
                                                                         + operator));
    }
}
