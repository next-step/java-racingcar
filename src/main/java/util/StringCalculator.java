package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_PATTERN = "[,:]";
    private final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String EMPTY_STRING = "";
    private final int ZERO = 0;

    public long addStringNumber(String text) {
        if(checkIfNullOrEmpty(text)) return ZERO;

        String delimiter = findDelimiter(text);
        String[] tokens = text.split(delimiter);

        long sum = 0;
        for(String token : tokens) {
            if(checkIfIllegalStringNumber(token) == true) continue;

            long number = convertStringToNumber(token);
            if (checkIfNegativeNumber(number)) throw new RuntimeException();
            sum += number;
        }

        return sum;
    }

    private Boolean checkIfNullOrEmpty(String text) {
        return text == null || text.equals(EMPTY_STRING);
    }

    private Boolean checkIfIllegalStringNumber(String token) {
        return token.equals("//");
    }

    private long convertStringToNumber(String token) {
        return Long.parseLong(token.replace("\n", ""));
    }

    private Boolean checkIfNegativeNumber(long number) {
        return number < ZERO;
    }

    private String findDelimiter(String text) {
        String comma = ",";
        String colon = ":";

        if(text.contains(comma) || text.contains(colon)) return DEFAULT_PATTERN;

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return EMPTY_STRING;
    }
}
