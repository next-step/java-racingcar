package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String EMPTY_NUMBER = "0";

    private String customDelimiter;
    private String numberText;


    public int splitAndSum(String text) {
        clear();
        String[] numbers = split(text);
        return sum(numbers);
    }

    public String[] split(String text) {
        parse(text);
        List<String> delimiters = delimiters(customDelimiter);
        String delimiterRegex = delimiterRegex(delimiters);
        return numberText.split(delimiterRegex);
    }

    private int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            PositiveNumber positiveNumber = new PositiveNumber(number);
            result += positiveNumber.value();
        }

        return result;
    }

    private String delimiterRegex(List<String> delimiters) {
        StringBuilder stringBuilder = new StringBuilder();

        delimiters.stream().forEach(data -> {
            stringBuilder.append(data);
            stringBuilder.append("|");
        });

        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    private List<String> delimiters(String customDelimiter) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITER);

        if (customDelimiter != null) {
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    private void parse(String text) {
        String target = checkEmpty(text);

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(target);

        if (matcher.matches()) {
            customDelimiter = matcher.group(1);
            numberText = matcher.group(2);
            return;
        }

        customDelimiter = null;
        numberText = target;
    }

    private String checkEmpty(String text) {
        return empty(text) ? EMPTY_NUMBER : text;
    }

    private boolean empty(String text) {
        return text == null || text.isBlank();
    }

    public void clear() {
        customDelimiter = null;
        numberText = null;
    }
}