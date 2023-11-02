package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    @Override
    public String[] split(String text) {
        String delimiter = getDelimiter(text);
        if (Objects.isNull(delimiter)) {
            throw new RuntimeException();
        }
        text = text.split("\n")[1];
        return text.split(delimiter);
    }

    public String getDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        return matcher.find() ? matcher.group(1) : null;
    }
}
