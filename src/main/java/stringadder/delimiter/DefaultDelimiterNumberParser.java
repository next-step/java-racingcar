package stringadder.delimiter;

import java.util.Arrays;
import java.util.List;

public class DefaultDelimiterNumberParser extends DefaultNumberParser{
    private static final String DEFAULT_DELIMITERS = "[,:]";
    public static final String SEMI_COLON = ":";
    public static final String COMMA = ",";

    @Override
    public List<String> split(String text) {
        return Arrays.asList(text.split(DEFAULT_DELIMITERS));
    }

    @Override
    public boolean hasDelimiter(String text) {
        return text.contains(COMMA) || text.contains(SEMI_COLON) || text.length() == 1;
    }

}
