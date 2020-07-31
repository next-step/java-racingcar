package camp.nextstep.edu.rebellion.calc;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculationOperator {
    ADD("+", (val1, val2) -> (val1 + val2)),
    SUB("-", (val1, val2) -> (val1 - val2)),
    MUL("*", (val1, val2) -> (val1 * val2)),
    DIV("/", (val1, val2) -> {
        if (0 == val2) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return (val1 / val2);
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculationOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int compute(int val1, int val2) {
        return this.expression.apply(val1, val2);
    }

    public static CalculationOperator of(String operator) {
        return Arrays.stream(CalculationOperator.values())
                .filter(oper -> oper.match(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자 입니다 : " + operator));
    }

    private boolean match(String operator) {
        return this.operator.equals(operator);
    }
}
