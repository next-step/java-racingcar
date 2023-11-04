package calculator;

public class DefaultDelimiter implements Delimiter {

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public String[] split(String text) {
        return text.split(DEFAULT_DELIMITER);
    }
}
