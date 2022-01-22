package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator {

    public static final List<String> SYMBOLS = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    private static final String NOT_OPERATIONS_MESSAGE = "연산기호가 아닙니다.";
    private List<String> operators;

    private Operator() {
        operators = new ArrayList<>();
    }

    public static Operator get() {
        return new Operator();
    }

    public void addOperator(String ope) {
        if (!SYMBOLS.contains(ope)) {
            throw new IllegalArgumentException(NOT_OPERATIONS_MESSAGE);
        }
        operators.add(ope);
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public void clear() {
        this.operators.clear();
    }
}
