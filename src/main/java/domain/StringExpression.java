package domain;

import java.util.ArrayList;
import java.util.Iterator;
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
        if(expression == null || "".equals(expression.trim())) {
            throw new IllegalArgumentException("Expression is null or empty.");
        }

        String[] splitExpression = splitExpression(expression);
        List<Integer> stringNumbers = IntStream.range(0, splitExpression.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> parseNumber(splitExpression[i]))
                .collect(Collectors.toList());
        List<StringOperation> stringOperations = IntStream.range(0, splitExpression.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> StringOperation.of(splitExpression[i]))
                .collect(Collectors.toList());
        
        validate(stringNumbers, stringOperations);

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

    private static void validate(List<Integer> stringNumbers, List<StringOperation> stringOperations) {
        if(stringNumbers.size() != stringOperations.size() + 1) {
            throw new IllegalArgumentException("Expression is not perfect.");
        }
    }

    public Integer solve() {
        Integer result = 0;
        Iterator<Integer> numbersIterator = numbers.iterator();
        Iterator<StringOperation> operationIterator = makeSolvingOperations().iterator();

        while (numbersIterator.hasNext()) {
            Integer nextNumber = numbersIterator.next();
            StringOperation nextOperation = operationIterator.next();
            result = nextOperation.operate(result, nextNumber);
        }

        return result;
    }

    private List<StringOperation> makeSolvingOperations() {
        List<StringOperation> solvingOperations = new ArrayList<>();
        solvingOperations.add(StringOperation.ADD);
        solvingOperations.addAll(this.operations);
        return solvingOperations;
    }
}
