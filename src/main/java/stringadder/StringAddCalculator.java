package stringadder;

import stringadder.delimiter.DefaultNumberParser;
import stringadder.delimiter.NumberParser;
import stringadder.delimiter.DelimiterNumberParserFactory;

import java.util.List;

public class StringAddCalculator {
    private static final int NOTING = 0;
    private final DelimiterNumberParserFactory delimiterNumberParserFactory;

    public StringAddCalculator(DelimiterNumberParserFactory delimiterNumberParserFactory) {
        this.delimiterNumberParserFactory = delimiterNumberParserFactory;
    }

    public int splitAndSum(String text) {
        if (isBlank(text)) {
            return NOTING;
        }

        NumberParser numberParser = delimiterNumberParserFactory.getNumberParser(text);
        return calculatePositiveNumberSumFrom(numberParser.split(text));
    }

    private int calculatePositiveNumberSumFrom(List<String> strings) {
        return strings.stream()
                .mapToInt(DefaultNumberParser::parsePositiveInt)
                .sum();
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }


}
