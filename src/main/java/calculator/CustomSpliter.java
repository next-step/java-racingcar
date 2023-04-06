package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSpliter implements Spliter {
    @Override
    public String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (!m.find()) {
            return new String[0];
        }

        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }
}
