package calculator2;

import com.google.common.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberParser {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|;";

    private StringNumberParser() {

    }

    public static String[] parse(String text) {
        if(Strings.isNullOrEmpty(text)) {
            return parseEmptyTexts();
        }

        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            return parseCustomTexts(m);
        }

        return parseDefaultTexts(text);
    }

    private static String[] parseCustomTexts(Matcher m) {
        String delimiter = m.group(1);
        return m.group(2).split(delimiter);
    }

    private static String[] parseEmptyTexts() {
        return new String[] { "0" };
    }

    private static String[] parseDefaultTexts(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

}
