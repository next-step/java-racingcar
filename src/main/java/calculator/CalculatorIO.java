package calculator;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class CalculatorIO {
    private final String text;
    public static final String SEPARATOR = ",|:";

    public CalculatorIO(String text) {
        this.text = text;
    }

    public static String[] splitCustomSeparatorOrDefault(String text) {
        String[] result = splitCustomSeparator(text);
        if (result != null) return result;
        return text.split(SEPARATOR);
    }
    public static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
    private static String[] splitCustomSeparator(String text) {
        Matcher matcher = compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return null;
    }

}
