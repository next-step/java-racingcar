package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", CalNumber::plusBy),
    MINUS("-", CalNumber::minusBy),
    MULTIPLE("*", CalNumber::multipleBy),
    DIVIDED("/", CalNumber::dividedBy);

    private final String operation;
    private final BiFunction<CalNumber, CalNumber, CalNumber> calculate;


    Operator(String operation,
        BiFunction<CalNumber, CalNumber, CalNumber> calculate) {
        this.operation = operation;
        this.calculate = calculate;
    }

    public static BiFunction<CalNumber, CalNumber, CalNumber> of(String operation) {
        return Arrays.stream(Operator.values())
            .filter(o -> o.operation.equals(operation))
            .map(o -> o.calculate)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("operation이 잘못되었습니다."));
    }


}
