package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringExpression {

    private final List<Integer> numbers;
    private final List<StringOperation> operations;

    private static final String BLANK = " ";
    private static final int EVEN_NUMBER_REMAIN_AFTER_MODULO = 0;
    private static final int ODD_NUMBER_REMAIN_AFTER_MODULO = 1;

    private StringExpression(List<Integer> numbers, List<StringOperation> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public static StringExpression newInstance(String expression) {
        if (expression == null || "".equals(expression.trim())) {
            throw new IllegalArgumentException("Expression is null or empty.");
        }

        String[] splitExpression = splitExpression(expression);

        List<Integer> stringNumbers = convertToList(splitExpression, i -> i % 2 == EVEN_NUMBER_REMAIN_AFTER_MODULO, StringExpression::parseNumber);
        List<StringOperation> stringOperations = convertToList(splitExpression, i -> i % 2 == ODD_NUMBER_REMAIN_AFTER_MODULO, StringOperation::of);

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

    private static <R> List<R> convertToList(String[] splitExpression, IntPredicate intPredicate, Function<String, R> mapper) {
        return IntStream.range(0, splitExpression.length)
                .filter(intPredicate)
                .mapToObj(i -> splitExpression[i])
                .map(mapper)
                .collect(Collectors.toList());
    }

    private static void validate(List<Integer> stringNumbers, List<StringOperation> stringOperations) {
        if (stringNumbers.size() != stringOperations.size() + 1) {
            throw new IllegalArgumentException("Expression is not perfect.");
        }
    }

    public Integer solve() {
        Integer result = 0;
        List<StringOperation> solvingOperations = makeSolvingOperations();

        for (int i = 0; i < numbers.size(); i++) {
            Integer nextNumber = numbers.get(i);
            StringOperation nextOperation = solvingOperations.get(i);
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
