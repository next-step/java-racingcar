package step2.Delimiter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private String delimiter;

    @Override
    public boolean matches(String input) {
        return CUSTOM_PATTERN.matcher(input).matches();
    }

    @Override
    public List<String> split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (!matcher.matches()) {
            return List.of(input);
        }

        delimiter = matcher.group(1);
        String numberGroups = matcher.group(2);

        return List.of(numberGroups.split(Pattern.quote(delimiter)));
    }
}

