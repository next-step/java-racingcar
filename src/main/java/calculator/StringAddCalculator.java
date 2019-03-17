package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int EMPTY_RETURN = 0;
    private static final int MONO_TEXT = 1;


    public int add(String inputText) throws IllegalArgumentException {
        if(isNull(inputText) || inputText.isEmpty()) {
            return EMPTY_RETURN;
        }
        if(inputText.length() == MONO_TEXT) {
            return Integer.parseInt(inputText);
        }

        if (inputText.contains("-")) {
            throw new IllegalArgumentException("음수는 안됩니다");
        }

        if (inputText.contains(",") | inputText.contains(":")) {
            return sum(parseString(inputText));
        }

        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(inputText);
        if (matcher.find()) {
            return sum(parseMatcher(matcher));
        }
        return 1;
    }

    private String[] parseMatcher(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private boolean isNull(String text) {
        return text == null;
    }

    private String[] parseString(String text) {
        return text.split(",|:");
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
