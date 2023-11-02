package calculator;

public class DefaultDelimiter implements Delimiter {

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String getDelimiter(String text) {
        return DEFAULT_DELIMITER;
    }

    @Override
    public String[] getTokens(String text) {
        return text.split(getDelimiter(text));
    }
}
