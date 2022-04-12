package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public int sum() {
        Operand accOperand = new Operand();

        for (Operand operand : operands) {
            accOperand = accOperand.sum(operand);
        }

        return accOperand.getValue();
    }

    public static Operands fromStringList(List<String> list) {
        List<Operand> operands = new ArrayList<>();

        for (String stringOperand : list) {
            operands.add(new Operand(stringOperand));
        }

        return new Operands(operands);
    }
}
