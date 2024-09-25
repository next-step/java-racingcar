package calculator;

import calculator.util.SplitUtil;

import java.util.Arrays;

public class StringAddCalculator {
    private final Integer[] operands;

    public StringAddCalculator(String input) {
        this.operands = SplitUtil.integers(input);
    }

    public int sum() {
        return Arrays.stream(operands)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
