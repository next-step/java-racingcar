package step2;

import step2.delimiter.NumberParser;
import step2.delimiter.DelimiterNumberParserFactory;
import step2.exception.StringAddIllegalArgumentException;

import java.util.List;

public class StringAddCalculator {
    private static final int NOTING = 0;
    private final DelimiterNumberParserFactory delimiterNumberParserFactory;

    public StringAddCalculator(DelimiterNumberParserFactory delimiterNumberParserFactory) {
        this.delimiterNumberParserFactory = delimiterNumberParserFactory;
    }

    public int splitAndSum(String text) {
        if (isEmpty(text)) {
            return NOTING;
        }
        NumberParser numberParser = delimiterNumberParserFactory.getNumberParser(text);
        List<String> strings = numberParser.splitFrom(text);
        return calculatePositiveNumberSumFrom(strings);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private int calculatePositiveNumberSumFrom(List<String> strings) {
        return strings.stream()
                .mapToInt(str -> {
                    int value = Integer.parseInt(str);
                    validatePositive(value);
                    return value;
                })
                .sum();
    }

    private void validatePositive(int num) {
        if (num < 0) {
            throw StringAddIllegalArgumentException.INVALID_NEGATIVE_INPUT_NUMBER;
        }
    }


}
