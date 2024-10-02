package stringadder.delimiter;

import stringadder.exception.StringAddIllegalArgumentException;

public class DelimiterNumberParserFactory {
    private final DefaultDelimiterNumberParser defaultDelimiter = new DefaultDelimiterNumberParser();
    private final CustomDelimiterNumberParser customDelimiterNumberParser = new CustomDelimiterNumberParser();

    public NumberParser getNumberParser(String text) {
        if (customDelimiterNumberParser.hasDelimiter(text)) {
            return customDelimiterNumberParser;
        }
        if (defaultDelimiter.hasDelimiter(text)) {
            return defaultDelimiter;
        }
        throw StringAddIllegalArgumentException.DELIMITER_NOT_FOUND;
    }
}
