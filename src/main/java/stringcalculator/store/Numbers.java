package stringcalculator.store;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Numbers {
    private static final String NUMBER_FORMAT = "\\d+";

    private Queue<Double> numbers;

    public Numbers(String[] inputs) {
        this.numbers = collect(inputs);
    }

    public Queue<Double> getNumbers() {
        return new LinkedList<>(numbers);
    }

    public int getSize() {
        return this.numbers.size();
    }

    private Queue<Double> collect(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(this::isNumber)
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(LinkedList::new));

    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_FORMAT);
    }
}
