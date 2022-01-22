package calculator.domain;

import java.util.List;

public class Operators {

    private List<String> operators;
    private int pointer = 0;

    private Operators() {}

    public Operators(List<String> operators) {
        this.operators = operators;
    }

    protected List<String> getOperators() {
        return operators;
    }

    public String nextOperator() {
        return operators.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < operators.size();
    }
}
