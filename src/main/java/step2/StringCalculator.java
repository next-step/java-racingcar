package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    public static CalculatorNumber calculate(String expression) {
        return Expression.from(expression).compute();
    }
}
