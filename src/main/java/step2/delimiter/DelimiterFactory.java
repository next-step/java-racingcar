package step2.delimiter;

public class DelimiterFactory {
    private final DefaultDelimiter defaultDelimiter = new DefaultDelimiter();
    private final CustomDelimiter customDelimiter = new CustomDelimiter();

    public Delimiter getDelimiter(String text) {
        if (customDelimiter.hasCustomDelimiter(text)) {
            return customDelimiter;
        }
        return defaultDelimiter;
    }
}
