package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        validateNotEmpty(operands);
        this.operands = operands;
    }

    private void validateNotEmpty(List<Operand> operands) {
        if (isNullOrEmpty(operands)) {
            throw new IllegalArgumentException("빈 컬렉션은 합을 구할 수 없다.");
        }
    }

    private boolean isNullOrEmpty(List<Operand> operands) {
        return operands == null || operands.isEmpty();
    }

    public int sum() {
        return operands.stream().mapToInt(Operand::getValue).sum();
    }

    public static Operands from(List<String> textForOperands) {
        return new Operands(textForOperands.stream().map(Operand::new).collect(Collectors.toList()));
    }
}
