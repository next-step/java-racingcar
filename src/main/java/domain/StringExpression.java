package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringExpression {

    private final List<Integer> numbers;
    private final List<StringOperation> operations;

    private static final String BLANK = " ";

    private StringExpression(List<Integer> numbers, List<StringOperation> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public static StringExpression newInstance(String expression) {
        String[] splitExpression = splitExpression(expression);
        List<Integer> stringNumbers = IntStream.range(0, splitExpression.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> parseNumber(splitExpression[i]))
                .collect(Collectors.toList());
        List<StringOperation> stringOperations = IntStream.range(0, splitExpression.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> StringOperation.valueOf(splitExpression[i]))
                .collect(Collectors.toList());

        return new StringExpression(stringNumbers, stringOperations);
    }

    private static String[] splitExpression(String expression) {
        return expression.split(BLANK);
    }

    private static Integer parseNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Expression contains character (not number)");
        }
    }
}
