package calculator;

import java.util.List;

public class Operand {
    List<Integer> operands;

    public Operand(List<Integer> operands) {
        this.operands = operands;
    }

    public void add(int operand) {
        this.operands.add(operand);
    }

    public int operand(int i) {
        return this.operands.get(i);
    }

    public int length() {
        return this.operands.size();
    }
}
