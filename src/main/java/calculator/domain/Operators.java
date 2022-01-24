package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private static final String NOT_OPERATIONS_MESSAGE = "연산기호가 아닙니다.";
    private List<Operator> operators;

    private Operators() {
        operators = new ArrayList<>();
    }

    public static Operators get() {
        return new Operators();
    }

    public void addOperator(String symbol) {
        operators.add(Operator.fromString(symbol)
            .orElseThrow(() -> new IllegalArgumentException(NOT_OPERATIONS_MESSAGE)));
    }

    public List<Operator> getOperators() {
        return this.operators;
    }
}
