package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if(input == "" || input == null) {
            return 0;
        }

        String[] stringTypeNumbers = getStrings(input);
        int sum = parseIntAndGetSum(stringTypeNumbers);
        return sum;
    }

    private static int parseIntAndGetSum(String[] stringTypeNumbers) {
        int sum = 0;
        for (String stringTypeNumber : stringTypeNumbers) {
            sum += getParseInt(stringTypeNumber);
        }
        return sum;
    }

    private static int getParseInt(String stringTypeNumber) throws RuntimeException {

        try {
            int number = Integer.parseInt(stringTypeNumber);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] getStrings(String input) {

        String[] stringTypeNumbers;

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            stringTypeNumbers = matcher.group(2).split("\\" + customDelimiter);
        } else {
            stringTypeNumbers = input.split(",|:");
        }
        return stringTypeNumbers;
    }
}
