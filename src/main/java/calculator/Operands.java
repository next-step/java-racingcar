package calculator;

import java.util.List;
import java.util.stream.Collectors;

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
        return new Operands(list.stream().map(Operand::new).collect(Collectors.toList()));
    }
}
