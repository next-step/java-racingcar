package step1;

import java.util.ArrayList;
import java.util.List;

import static step1.Utils.ValidationUtils.isNumeric;

public class OperandCollection {
    private List<Integer> operands;

    public OperandCollection() {
        operands = new ArrayList<>();
    }

    public void add(String operand) {
        if (!isNumeric(operand)) {
            throw new IllegalArgumentException("It is not numeric");
        }

        operands.add(Integer.parseInt(operand));
    }

    public int get(int index) {
        return operands.get(index);
    }
}
