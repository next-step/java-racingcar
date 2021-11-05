package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", CalNumber::plusBy),
    MINUS("-", CalNumber::minusBy),
    MULTIPLE("*", CalNumber::multipleBy),
    DIVIDED("/", CalNumber::dividedBy);

    private final String symbol;
    private final BiFunction<CalNumber, CalNumber, CalNumber> calculate;

    public BiFunction<CalNumber, CalNumber, CalNumber> getCalculate() {
        return calculate;
    }

    Operator(String symbol,
        BiFunction<CalNumber, CalNumber, CalNumber> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    private boolean isTargetSymbol(String targetSymbol) {
        return Objects.equals(symbol, targetSymbol);
    }

    public static BiFunction<CalNumber, CalNumber, CalNumber> of(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(o -> o.isTargetSymbol(symbol))
            .map(Operator::getCalculate)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("operation이 잘못되었습니다."));
    }

}
