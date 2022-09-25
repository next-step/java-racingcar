package stringcalculator;

import stringcalculator.domain.Positive;
import stringcalculator.domain.Positives;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {

        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (isOnlyNumber(text)) {
            Positive positive = new Positive(text);
            return positive.parseInt();
        }

        if (isSplitCommaOrColon(text)) {
            Positives positives = new Positives(text.split(",|:"));
            return positives.getSum();
        }

        return splitCustomDelimiterAndAdd(text);
    }


    private static int splitCustomDelimiterAndAdd(String text) {

        Matcher matcher = customDelimiterPattern.matcher(text);

        if (!matcher.find()) {
            throw new NoSuchElementException();
        }

        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);

        Positives positives = new Positives(tokens);

        return positives.getSum();
    }

    private static boolean isSplitCommaOrColon(String text) {
        return text.matches("^[0-9](.*)");
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isOnlyNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
