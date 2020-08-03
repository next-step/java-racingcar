package step2.collections;

import java.util.Arrays;

import static step2.constants.RegexPattern.OPERATOR_REGEX;

public class InputOperators {

    private final String[] operators;

    public InputOperators(String[] expression) {
        this.operators = filterOperator(expression);
    }

    public int size() {
        return this.operators.length;
    }

    public String get(int index) {
        return this.operators[index];
    }

    private String[] filterOperator(String[] expression) {
        return Arrays.stream(expression).filter(string -> OPERATOR_REGEX.matcher(string).matches()).toArray(String[]::new);
    }
}
