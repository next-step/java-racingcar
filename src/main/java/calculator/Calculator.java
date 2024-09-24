package calculator;

import java.util.stream.Stream;

public abstract class Calculator {

    protected abstract String[] operands(String str);

    public int sum(String str) {
        try {
            return sum(operands(str));
        } catch (NumberFormatException e) {
            throw new RuntimeException("The operand must be a number");
        }
    }

    private int sum(String[] operands) {
        return Stream.of(operands)
            .mapToInt(Integer::parseInt)
            .peek(operand -> {
                if (operand < 0) {
                    throw new RuntimeException("The operand cannot be a negative number");
                }
            })
            .sum();
    }
}
