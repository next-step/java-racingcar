package step2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Factor {
    private Queue<Number> numbers;
    private Queue<Operator> operators;

    public Factor(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split(" ");

        numbers = Arrays.stream(inputs)
                        .filter(i -> i.matches(FactorValidator.NUMBER_REGEX))
                        .map(Number::new)
                        .collect(Collectors.toCollection(LinkedList::new));

        operators = Arrays.stream(inputs)
                          .flatMap(i -> Arrays.stream(Operator.values()).filter(o -> o.isEqualTo(i)))
                          .collect(Collectors.toCollection(LinkedList::new));
    }

    public Number getNumbers(boolean isFirst, int result) {
        if(isFirst && result != 0) {
            return new Number(Integer.toString(result));
        }
        return numbers.poll();
    }

    public Operator getOperator() {
        return operators.poll();
    }

    public boolean isComplete() {
        return numbers.isEmpty() && operators.isEmpty();
    }
}
