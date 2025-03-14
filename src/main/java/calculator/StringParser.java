package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private StringParser() {

    }

    public static String[] split(String text) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher m = pattern.matcher(text);
        String delimiter = ",|:";

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter = String.join("|", delimiter, customDelimiter);
            text = m.group(2);
        }

        return text.split(delimiter);
    }
}
