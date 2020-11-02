package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String div;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String div, BiFunction<Double, Double, Double> biFunction) {
        this.div = div;
        this.biFunction = biFunction;
    }

    public String getDiv() {
        return div;
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a,b);
    }

    public static Operator getOperator(String div) {
        return Arrays.stream(values())
                .filter(operator -> { return operator.div.equals(div); })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static List<String> getDivs() {
        return Arrays.stream(values())
                .map(Operator::getDiv)
                .collect(Collectors.toList());
    }
}
