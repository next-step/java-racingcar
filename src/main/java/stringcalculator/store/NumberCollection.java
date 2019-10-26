package stringcalculator.store;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberCollection {
    private static final String NUMBER_FORMAT = "\\d+";

    private Queue<Double> numbers;

    public NumberCollection(String[] inputs) {
        this.numbers = collectNumbers(inputs);
    }

    public Queue<Double> getNumbers() {
        return new LinkedList<>(numbers);
    }

    private Queue<Double> collectNumbers(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(this::isNumber)
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(LinkedList::new));

    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_FORMAT);
    }
}
