package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {

    }

    public static int sum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.splitNumberString(text);
        return Arrays.stream(numbers).mapToInt(e -> new PositiveNumber(e).getValue()).sum();
    }
}
