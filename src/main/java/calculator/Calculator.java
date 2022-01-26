package calculator;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Calculator {

    private final LinkedList<Double> numbers;
    private final LinkedList<String> operators;

    public Calculator(LinkedList<String> numbers, LinkedList<String> operators) {
        this.numbers = numbers.stream().map(Double::parseDouble)
            .collect(Collectors.toCollection(LinkedList::new));
        this.operators = operators;
    }

    public Double execute() {
        while (operatorsNotEmpty()) {
            double v = Operator.operatorOf(operators.poll())
                .apply(numbers.poll(), numbers.poll());
            numbers.offerFirst(v);
        }
        return numbers.poll();
    }

    private boolean operatorsNotEmpty() {
        return !operators.isEmpty();
    }
}
