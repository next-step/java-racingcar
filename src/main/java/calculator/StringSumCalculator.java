package calculator;

import java.util.List;

public class StringSumCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        List<String> stringOperands = StringSplitterFactory.resolve(input).split();
        return Operands.fromStringList(stringOperands).sum();
    }
}
