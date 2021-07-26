package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Extractor {
    private List<Integer> numbers;
    private List<Operator> operators;

    private static final String delimiter = " ";

    public Extractor(String expression) {
        this.numbers = extractNumbers(expression.split(delimiter));
        this.operators = extractOperators(expression.split(delimiter));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    private List<Integer> extractNumbers(String[] expression) {
        return Arrays.stream(expression)
                .filter(this::isInteger)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<Operator> extractOperators(String[] expression) {
        return Arrays.stream(expression)
                .filter(this::isOperator)
                .map(Operator::operatorOf)
                .collect(Collectors.toList());
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return Arrays.stream(Operator.values())
                .anyMatch(v -> v.getOperator().equals(s));
    }

}
