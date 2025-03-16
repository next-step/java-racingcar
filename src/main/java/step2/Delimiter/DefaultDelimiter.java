package step2.Delimiter;

import java.util.List;
import java.util.regex.Pattern;

public class DefaultDelimiter implements Delimiter {
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(",|:");

    @Override
    public boolean matches(String input) {
        return true;
    }

    @Override
    public List<String> split(String input) {
        return List.of(DEFAULT_PATTERN.split(input));
    }
}

