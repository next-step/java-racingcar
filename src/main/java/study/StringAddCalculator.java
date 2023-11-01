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
    private String[] numbers;


    public int splitAndSum(String text) {
        clear();
        String target = checkEmpty(text);
        parse(target);
        split();
        return sum();
    }

    private void split() {
        List<String> delimiters = delimiters(customDelimiter);
        String delimiterRegex = delimiterRegex(delimiters);
        numbers = numberText.split(delimiterRegex);
    }

    private int sum() {
        int result = 0;

        for (String number : numbers) {
            checkInteger(number);
            result += Integer.parseInt(number);
        }

        return result;
    }

    private void checkInteger(String number) {
        checkNumber(number);
        negative(number);
    }

    private void checkNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다..", e);
        }
    }

    private void negative(String number) {
        if(Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
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

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (matcher.matches()) {
            customDelimiter = matcher.group(1);
            numberText = matcher.group(2);
            return;
        }

        customDelimiter = null;
        numberText = text;
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
        numbers = null;
    }
}