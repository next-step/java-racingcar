package stringcalculator.domain;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {
    private LinkedList<String> numbers;

    public Numbers(String[] expressions) {
        if (!isNumberStart(expressions)) {
            throw new IllegalArgumentException(Constant.MUST_START_NUMBER);
        }
        this.numbers = Stream.of(expressions)
                .filter(this::isNumber)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static boolean isNumberStart(String[] expressions) {
        return Constant.INTEGER_PATTERN.matcher(expressions[Constant.ZERO]).find();
    }

    public double get() {
        return Double.parseDouble(numbers.poll());
    }

    public boolean isNumber(String expression) {
        return Constant.INTEGER_PATTERN.matcher(expression).find();
    }

    public boolean hasNext() {
        return numbers.size() != Constant.ZERO;
    }
}
