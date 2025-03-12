package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private StringParser() {

    }

    public static String[] splitNumberString(String text) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher m = pattern.matcher(text);
        String delimiter = "[,:]";

        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return text.split(delimiter);
    }
}
