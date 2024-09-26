package step2.delimiter;

import java.util.Arrays;
import java.util.List;

public class DefaultDelimiterNumberParser implements NumberParser {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    @Override
    public List<String> splitFrom(String text) {
        return Arrays.asList(text.split(DEFAULT_DELIMITERS));
    }

    @Override
    public boolean isContainsDelimiter(String text) {
        return true;
    }

}
