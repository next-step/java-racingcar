package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public String[] split(String text) {
        String delimiter = getDelimiter(text);
        if (Objects.isNull(delimiter)) {
            throw new IllegalStateException("Custom Delimiter 가 아닙니다.");
        }
        text = text.split("\n")[1];
        return text.split(delimiter);
    }

    public String getDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        return matcher.find() ? matcher.group(1) : null;
    }
}
