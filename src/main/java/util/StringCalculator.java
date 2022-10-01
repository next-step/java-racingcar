package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_PATTERN = "[,:]";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String EMPTY_STRING = "";
    private final int ZERO = 0;

    public long addStringNumber(String text) {
        if (isNullOrEmpty(text)) return ZERO;

        String[] words = split(text);

        Positive[] numbers = convertStringToNumber(words);

        return sum(numbers);
    }

    public String[] split(String text) {
        String[] words = text.split(findDelimiter(text));
        String[] result = new String[words.length];

        int index = 0;

        for (String word : words) {
            if (isIllegalStringNumber(word)) continue;
            result[index++] = word.replace("\n", "");
        }

        return result;
    }

    private Boolean isNullOrEmpty(String text) {
        return text == null || text.equals(EMPTY_STRING);
    }

    private Boolean isIllegalStringNumber(String word) {
        return word.equals("//");
    }

    private Positive[] convertStringToNumber(String[] words) {

        Positive[] numbers = new Positive[words.length];

        for (int index = 0; index < words.length; index++) {
            String token = words[index];
            if (token != null && !isIllegalStringNumber(token)) {
                numbers[index] = new Positive(Integer.parseInt(token));
            }
        }

        return numbers;
    }

    private String findDelimiter(String text) {
        String comma = ",";
        String colon = ":";

        if (text.contains(comma) || text.contains(colon)) return DEFAULT_PATTERN;

        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return EMPTY_STRING;
    }

    private long sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            if (number == null) continue;
            result = result.plus(number);
        }

        return result.getNumber();
    }
}