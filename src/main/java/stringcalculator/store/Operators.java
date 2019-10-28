package stringcalculator.store;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operators {
    private static final String NUMBER_FORMAT = "\\d+";

    private Queue<String> operators;

    public Operators(String[] inputs) {
        this.operators = collect(inputs);
    }

    public Queue<String> getOperators() {
        return new LinkedList<>(operators);
    }

    public int getSize() {
        return this.operators.size();
    }

    private Queue<String> collect(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(this::isNotNumber)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private boolean isNotNumber(String input) {
        return !input.matches(NUMBER_FORMAT);
    }
}
