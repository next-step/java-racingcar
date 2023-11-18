package calculator.separator;

import java.util.List;

public class DefaultSeparator implements Separator {

    private static final String COMMA = ",";
    private static final String COLUMN = ":";
    public static final String DEFAULT_REGEX = COMMA + "|" + COLUMN;

    @Override
    public boolean matchable(String text) {
        return text.contains(COMMA) || text.contains(COLUMN);
    }

    @Override
    public List<String> separate(String text) {
        return List.of(text.split(DEFAULT_REGEX));
    }
}
