package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<String> operators = new ArrayList<>();
    private int pointer = 0;

    public Operators() {}

    protected List<String> getOperators() {
        return operators;
    }

    public String nextOperator() {
        return operators.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < operators.size();
    }

    public void addOperator(String operator) {
        operators.add(operator);
    }
}
