package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private List<Operator> operators;

    private Operators() {
        operators = new ArrayList<>();
    }

    public static Operators get() {
        return new Operators();
    }

    public void addOperator(String symbol) {
        operators.add(Operator.fromString(symbol));
    }

    public List<Operator> getOperators() {
        return this.operators;
    }
}
