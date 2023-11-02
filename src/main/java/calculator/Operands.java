package calculator;

import java.util.List;

public class Operands {
    List<Integer> operands;

    public Operands(List<Integer> operands) {
        this.operands = operands;
    }

    public void add(int operand) {
        this.operands.add(operand);
    }

    public int sum() {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
    }
}
