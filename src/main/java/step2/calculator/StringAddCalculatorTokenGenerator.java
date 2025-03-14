package step2.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorTokenGenerator {

    final static String[] defaultDelimiters = {",", ":"};
    final static String[] defaultCustomDelimiterRegexes = {"//(\\D)\n(.*)"};

    public static StringAddCalculatorToken[] generateTokens(String input) {
        if (input == null || input.isEmpty()) {
            return new StringAddCalculatorToken[]{new StringAddCalculatorToken(0)};
        }

        ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(defaultDelimiters));

        for (String customDelimiterRegex : defaultCustomDelimiterRegexes) {
            Matcher matcher = Pattern.compile(customDelimiterRegex).matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                delimiters.add(customDelimiter);
                input = matcher.group(2);
            }
        }

        String[] stringTokens = input.split(String.format("[%s]", String.join("", delimiters)));
        if (input.startsWith("-") && delimiters.contains("-")) {
            stringTokens[1] = "-" + stringTokens[1];
        }

        StringAddCalculatorToken[] stringAddCalculatorTokens = new StringAddCalculatorToken[stringTokens.length];
        for (int i = 0; i < stringTokens.length; i++) {
            stringAddCalculatorTokens[i] = new StringAddCalculatorToken(stringTokens[i]);
        }

        return stringAddCalculatorTokens;
    }

}
