package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import utils.StringUtils;

public class Calculator {

    public static final String SPACE = "\\s+";

    public static int calculate(String text) {
        if (StringUtils.isNullOrBlank(text)) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        List<String> tokens = splitTokens(text);
        Queue<Operation> operations = operationsFromTokens(tokens);
        Queue<Integer> numbers = numbersFromTokens(tokens);
        return calculate(operations, numbers);
    }

    private static int calculate(Queue<Operation> operations, Queue<Integer> numbers) {
        int result = numbers.remove();
        while (!operations.isEmpty()) {
            Operation op = operations.remove();
            int number = numbers.remove();
            result = op.apply(result, number);
        }
        return result;
    }

    private static Queue<Operation> operationsFromTokens(List<String> tokens) {
        return IntStream
                .range(0, tokens.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(tokens::get)
                .map(token -> BasicOperation.fromString(token)
                        .orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static Queue<Integer> numbersFromTokens(List<String> tokens) {
        return IntStream
                .range(0, tokens.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(tokens::get)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static List<String> splitTokens(String input) {
        return Arrays.asList(input.split(SPACE));
    }
}
