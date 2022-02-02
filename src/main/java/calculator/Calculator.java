package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final List<Double> numbers;
    private final List<String> operators;

    public Calculator(List<String> numbers, List<String> operators) {
        this.numbers = numbers.stream().map(Double::parseDouble)
            .collect(Collectors.toCollection(LinkedList::new));
        this.operators = operators;
    }

    public Double execute() {
        Double result = numbers.get(0);
        numbers.remove(0);
        for(final String operator: operators) {
            result = Operator.operatorOf(operator).apply(result, numbers.get(0));
            numbers.remove(0);
        }
        return result;
    }
}
