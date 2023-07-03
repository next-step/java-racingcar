package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static String[] parse(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(":|,");
    }
}
