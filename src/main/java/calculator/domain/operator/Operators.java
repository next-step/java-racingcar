package calculator.domain.operator;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<Operator> operators;

    public Operators() {
        this.operators = new ArrayList<>();
    }

    public void add(Operator element) {
        operators.add(element);
    }

    public List<Operator> get() {
        return operators;
    }

    public Operator get(int index) {
        return operators.get(index);
    }
}
