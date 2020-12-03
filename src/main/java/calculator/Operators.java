package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operators {

    private final List<Operator> operators;

    public Operators(final List<Operator> operators) {
        this.operators = new ArrayList<>(Collections.unmodifiableList(operators));
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    public int count() {
        return operators.size();
    }
}
