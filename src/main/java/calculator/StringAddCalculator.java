package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        ExtractDelimiter extractDelimiter = new ExtractDelimiter(text);
        if (extractDelimiter.isExtracted()) {
            return split(extractDelimiter.getDelimiter(), extractDelimiter.getText());
        }

        return split(DEFAULT_DELIMITER, text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int split(String delimiter, String text) {
        String[] tokens = text.split(delimiter);
        return sum(toInts(tokens));
    }

    private static PositiveIntegers toInts(String[] values) {
        List<PositiveInteger> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(new PositiveInteger(value));
        }
        return new PositiveIntegers(numbers);
    }

    private static int sum(PositiveIntegers numbers) {
        return numbers.sum();
    }
}
