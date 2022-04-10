package calculator;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        List<String> stringOperands = new StringSplitter(input).split();
        return SumOperands.fromStringList(stringOperands).sum();
    }
}
