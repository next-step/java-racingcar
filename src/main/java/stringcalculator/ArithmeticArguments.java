package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticArguments {
    private final List<Integer> operands;
    private final List<Operator> operators;

    public ArithmeticArguments(List<Integer> operands, List<Operator> operators) {
        this.operands = new ArrayList<>(operands);
        this.operators = new ArrayList<>(operators);
    }

    public int nextOperand() { return this.operands.remove(0);}

    public Operator nextOperator() {
        return this.operators.remove(0);
    }

    public boolean hasNextOperator() {
        return !operators.isEmpty();
    }
}
