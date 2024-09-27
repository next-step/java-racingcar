package calculator;

import calculator.util.SplitUtil;

import java.util.List;

public class StringAddCalculator {
    private final List<Integer> operands;

    public StringAddCalculator(String input) {
        this.operands = SplitUtil.ints(input);
    }

    public int sum() {
        return operands.stream()
                .mapToInt(i -> i).sum();
    }
}
