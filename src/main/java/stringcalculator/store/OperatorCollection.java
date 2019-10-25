package stringcalculator.store;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class OperatorCollection {
    private static final String NUMBER_FORMAT = "\\d";

    private Queue<String> operators;

    public OperatorCollection(String[] inputs) {
        this.operators = collectOperators(inputs);
    }

    public Queue<String> getOperators() {
        return new LinkedList<>(operators);
    }

    private Queue<String> collectOperators(String[] inputs) {
        return Arrays.stream(inputs)
                .filter(this::isNotNumber)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private boolean isNotNumber(String input) {
        return !input.matches(NUMBER_FORMAT);
    }
}
