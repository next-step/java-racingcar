package calculator;

import java.util.List;

public class Calculator {

    private static final String ZERO = "0";

    public PositiveNumber calculate(String text) {
        if (isNothing(text)) {
            return calculateSumWithNothing();
        }

        return calculateSum(Separator.separate(text));
    }

    private boolean isNothing(String text) {
        return text == null || text.isBlank() || text.isEmpty();
    }

    private PositiveNumber calculateSumWithNothing() {
        return new PositiveNumber(ZERO);
    }

    private PositiveNumber calculateSum(List<String> separatedText) {
        PositiveNumber sum = new PositiveNumber(ZERO);
        for (String value : separatedText) {
            PositiveNumber number = new PositiveNumber(value);
            sum = sum.plus(number);
        }
        return sum;
    }
}
