package calculator2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private final static String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private final static String BASIC_SEPARATOR = ":|,";
    private final static String ZERO = "0";

    private boolean isBlank(String num) {
        return num == null || num.isBlank();
    }

    public String[] tokenNum(String num) {
        if (isBlank(num)) {
            return new String[]{ZERO};
        }
        return splitNum(num);
    }

    private String[] splitNum(String num) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(num);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return num.split(BASIC_SEPARATOR);
    }

}
