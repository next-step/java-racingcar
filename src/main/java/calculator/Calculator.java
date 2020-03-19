package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public int calc(String expression) {
        String[] tokens = expression.split("[-+/*]", -1);
        int[] numbers = Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();

        List<String> operations = Arrays.stream(expression.split("[0-9]"))
                .filter((item) -> !"".equals(item))
                .collect(Collectors.toList());

        List<BiFunction<Integer, Integer, Integer>> functions = operations.stream()
                .map(op -> {
                    switch (op) {
                        case "+":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b;
                        case "-":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a - b;
                        case "*":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a * b;
                        case "/":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a / b;
                        default:
                            throw new RuntimeException("구현되지 않은 연산자");
                    }
                })
                .collect(Collectors.toList());

        int result = numbers[0];

        for(int i=0; i<functions.size(); i++) {
            result = functions.get(i).apply(result, numbers[i+1]);
        }
        return result;
    }
}
