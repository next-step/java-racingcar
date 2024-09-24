package step2.delimiter;

public class DefaultDelimiter implements Delimiter {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    @Override
    public String[] splitFrom(String text) {
        return text.split(DEFAULT_DELIMITERS);
    }

}
