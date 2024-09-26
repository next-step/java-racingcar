package step2.delimiter;

public class DelimiterNumberParserFactory {
    private final DefaultDelimiterNumberParser defaultDelimiter = new DefaultDelimiterNumberParser();
    private final CustomDelimiterNumberParser customDelimiterNumberParser = new CustomDelimiterNumberParser();

    public NumberParser getNumberParser(String text) {
        if (customDelimiterNumberParser.isContainsDelimiter(text)) {
            return customDelimiterNumberParser;
        }
        return defaultDelimiter;
    }
}
