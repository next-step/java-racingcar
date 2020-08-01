package step2.collections;

public class InputOperators {

    private final String[] operators;

    public InputOperators(String[] operators) {
        this.operators = operators;
    }

    public Integer size() {
        return this.operators.length;
    }

    public String get(Integer index) {
        return this.operators[index];
    }
}
