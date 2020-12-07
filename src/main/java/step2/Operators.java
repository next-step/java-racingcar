package step2;

import java.util.List;

public class Operators {

    private List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    public int size() {
        return this.operators.size();
    }

}
