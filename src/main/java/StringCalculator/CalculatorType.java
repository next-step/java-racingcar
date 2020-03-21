package StringCalculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum CalculatorType {
    ADD("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    SUBTRACT("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLE("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> {
        validateNumberWhenDivideNumber(secondNumber);
        return firstNumber / secondNumber;
    });

    final private String symbol;
    final private BiFunction<Double, Double, Double> operator;

    final private static Map<String, CalculatorType> CALCULATOR_TYPE_MAP = Arrays.stream(CalculatorType.values())
            .collect(Collectors.toMap(CalculatorType::getSymbol, CalculatorType -> CalculatorType));

    CalculatorType(final String symbol, final BiFunction<Double, Double, Double> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public String getSymbol() {
        return this.symbol;
    }

    private static void validateSymbol(final String symbol) {
        if (!CALCULATOR_TYPE_MAP.containsKey(symbol)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberWhenDivideNumber(final Double number) {
        if (number == 0.0) {
            throw new IllegalArgumentException();
        }
    }

    public static CalculatorType getCalculatorWithSymbol(final String symbol) {
        validateSymbol(symbol);
        return CALCULATOR_TYPE_MAP.get(symbol);
    }

    public Double calculate(final Double firstNumber, final Double secondNumber) {
        return this.operator.apply(firstNumber, secondNumber);
    }
}
