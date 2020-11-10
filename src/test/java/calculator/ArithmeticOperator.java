package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArithmeticOperator {

    PLUS((a, b) -> a + b, "+"),
    MINUS((a, b) -> a - b, "-"),
    MULT((a, b) -> a * b, "*"),
    DIV((a, b) -> a / b, "/");

    public static final int REQUIRED_NUM_OPERANDS = 2;

    private BiFunction<Long, Long, Long> biFunction;
    private String mark;

    ArithmeticOperator(BiFunction<Long, Long, Long> f, String mark) {
        this.biFunction = f;
        this.mark = mark;
    }

    public static ArithmeticOperator of(String token) {
        return Arrays.stream(values())
                .filter(ao -> ao.mark.equals(token))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not an operator"));
    }

    public long eval(ArrayList<Long> operands) {
        if (operands.size() != REQUIRED_NUM_OPERANDS) {
            throw new ArithmeticException();
        }

        return biFunction.apply(operands.get(0), operands.get(1));
    }

}
