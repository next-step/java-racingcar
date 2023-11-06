package calculator.delimiter;

import calculator.Splitter;

import java.util.List;

public class DefaultDelimiter implements Delimiter{

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public List<String> parse(String text) {
        return Splitter.split(text, DEFAULT_DELIMITER);
    }
}
