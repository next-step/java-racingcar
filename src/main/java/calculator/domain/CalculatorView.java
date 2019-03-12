package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorView {

    public static String[] parseInputValues(String text) throws RuntimeException {
        String[] inputValues = new String[0];

        if (patternMatcher(text)) {
            inputValues = splitText(text);
        }

        return inputValues;
    }

    public static boolean patternMatcher(String text) throws RuntimeException {
        Pattern pattern = Pattern.compile("^(([0-9]+)\\s[[+],[-],[*],[/]]\\s)+([0-9]+)$");
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            throw new RuntimeException("패턴 불일치");
        }

        return true;
    }

    public static String[] splitText(String text) {

        return text.split(" ");
    }
}
