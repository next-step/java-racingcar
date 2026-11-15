package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*?)\n(.*)", Pattern.DOTALL);
    private static final String DEFAULT_SEPARATOR = ",|:";

    private final String separatorRegex;
    private final String body;

    public Tokenizer(String input) {
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (m.matches()) {
            CustomSeparator customSeparator = new CustomSeparator(m.group(1));
            separatorRegex = DEFAULT_SEPARATOR + "|" + customSeparator.toRegex();
            body = m.group(2);
            return;
        }

        separatorRegex = DEFAULT_SEPARATOR;
        body = input;
    }

    public List<String> tokens() {
        return List.of(body.split(separatorRegex));
    }
}
