package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<Operator> operators;
    private int pointer = 0;

    public Operators() {
        operators = new ArrayList<>();
    }

    protected List<Operator> getOperators() {
        return operators;
    }

    public Operator nextOperator() {
        return operators.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < operators.size();
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    protected void addOperatorAll(List<Operator> operators) {
        this.operators.addAll(operators);
    }
}
