package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
    public static final String DEFAULT_DELIMiTER_REGEX = ",|:";

    public static int splitAndSum(String text) throws Exception {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String delimiter = parseDelimiter(text);
        String parameter = parseParameter(text);

        String[] textArray = split(delimiter, parameter);
        return sum(textArray);
    }

    private static String parseDelimiter(String text) {
        Matcher matcher = INPUT_PATTERN.matcher(text);
        if(matcher.find()){
            return matcher.group(1);
        }
        return DEFAULT_DELIMiTER_REGEX;
    }

    private static String parseParameter(String text) {
        Matcher matcher = INPUT_PATTERN.matcher(text);
        if(matcher.find()){
            return matcher.group(2);
        }
        return text;
    }

    private static String[] split(String delimiter, String parameter) {
        String[] textArray = parameter.split(delimiter);
        return textArray;
    }

    private static int sum(String[] textArray) throws Exception {
        int result = 0;
        for(String str: textArray) {
            result += toPositiveInt(str);
        }
        return result;
    }

    private static int toPositiveInt(String str) throws Exception {
        int result = Integer.parseInt(str);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }
}
