package calculator.domain;

import java.util.List;

public class Operators {
    private List<String> operators;

    private Operators() {}

    public Operators(List<String> operators) {
        this.operators = operators;
    }

    protected List<String> getOperators() {
        return operators;
    }
}
