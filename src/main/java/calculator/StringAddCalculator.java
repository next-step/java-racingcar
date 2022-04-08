package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        if (isaBlank(value)) {
            return 0;
        }

        PatternExtractor patternExtractor = new PatternExtractor(value);
        String[] numbers = patternExtractor.getText().split(patternExtractor.getSeparator());

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean isaBlank(String value) {
        return value == null || value.isBlank();
    }
}
