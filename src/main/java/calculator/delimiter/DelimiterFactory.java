package calculator.delimiter;

public class DelimiterFactory {
    public Delimiter createDelimiter(String text) {

        if (CustomDelimiter.match(text)) {
            return new CustomDelimiter();
        }

        return new DefaultDelimiter();
    }
}
