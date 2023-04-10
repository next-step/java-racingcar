package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSpliter implements Spliter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    @Override
    public String[] split(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (!m.find()) {
            return new String[0];
        }

        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    @Override
    public boolean isSupport(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        return m.find();
    }
}
