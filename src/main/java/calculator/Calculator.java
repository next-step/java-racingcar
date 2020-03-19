package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public int calculate(String text) {
        final String expression = getExpression(text);

        int[] numbers = getNumbers(expression);

        List<BiFunction<Integer, Integer, Integer>> operations = getOperations(expression);

        return calculateEachNumbers(numbers, operations);
    }

    private String getExpression(String text) {
        if(!text.startsWith("-")) {
            text = "+" + text;
        }
        return text;
    }

    private int calculateEachNumbers(int[] numbers, List<BiFunction<Integer, Integer, Integer>> operations) {
        int result = 0;
        for(int i=0; i<operations.size(); i++) {
            result = operations.get(i).apply(result, numbers[i + 1]);
        }
        return result;
    }

    private List<BiFunction<Integer, Integer, Integer>> getOperations(String expression) {
        List<String> operations = Arrays.stream(expression.split("[0-9]"))
                .collect(Collectors.toList());

        return operations.stream()
                .map(op -> {
                    switch (op) {
                        case "-":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a - b;
                        case "*":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a * b;
                        case "/":
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a / b;
                        case "+":
                        default:
                            return (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b;
                    }
                })
                .collect(Collectors.toList());
    }

    private int[] getNumbers(String expression) {
        String[] tokens = expression.split("[-+/*]", -1);
        return Stream.of(tokens)
                .mapToInt(item -> {
                    try {
                        return Integer.parseInt(item);
                    } catch (NumberFormatException ex) {
                        return 0;
                    }
                })
                .toArray();
    }
}
