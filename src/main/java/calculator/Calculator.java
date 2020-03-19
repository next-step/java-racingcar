package calculator;

import java.util.stream.Stream;

public class Calculator {
    public int calc(String expression) {
        String[] tokens = expression.split("[+]");
        return Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
