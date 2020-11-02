package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (first, second) -> first - second),
    MULTIPLE("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if( second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    });

    private final String operatorType;
    private final BiFunction<Integer, Integer, Integer> calculate;
    Operator(String operatorType,
             BiFunction<Integer, Integer, Integer> calculator) {
        this.operatorType = operatorType;
        this.calculate = calculator;
    }

    public int operate(int first, int second) {
        return calculate.apply(first, second);
    }

    public static int calculate(int first, String operatorType, int second) {
        return Arrays.stream(values())
                .filter(operator -> operator.operatorType.equals(operatorType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .operate(first, second);
    }

}
