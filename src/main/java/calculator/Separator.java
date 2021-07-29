package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {

    private List<Integer> numbers;
    private List<Operator> operators;

    private static final String delimiter = " ";

    public Separator(String expression) {
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

    public boolean isInteger(String expression) {
        try {
            Integer.parseInt(expression);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isOperator(String expression) {
        return Arrays.stream(Operator.values())
                .anyMatch(v -> v.getSymbol().equals(expression));
    }
}
