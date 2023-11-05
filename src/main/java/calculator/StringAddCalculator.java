package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT = 0;
    private static final String DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum (String input) {
        int sum = 0;

        if ( isEmpty(input) ) {
            return DEFAULT;
        }

        if ( isOneNumber(input) ) {
            return Integer.parseInt(input);
        }

        String numbers = input;
        Matcher m = PATTERN.matcher(input);

        if (m.find()){
            numbers = m.group(2);
        }

        String[] tokens = numbers.split(findDelimiter(input));

        for (int i=0; i < tokens.length; i++ ) {
            int number = Integer.parseInt(tokens[i]);
            isminusNumber(number);
            sum += number;
        }
        return sum;
    }

    private static boolean isEmpty(String input) {
        if ( input == null || "".equals(input) ){
            return true;
        }
        return false;
    }

    private static boolean isOneNumber(String input) {
        if(getSize(input) == 1) {
            return true;
        }
        return false;
    }

    private static String findDelimiter (String input) {
        Matcher m = PATTERN.matcher(input);

        if ( m.find() ) {
            return m.group(1);
        }
        return DELIMITER;
    }

    private static int getSize(String input) {
        return input.split(findDelimiter(input)).length;
    }

    private static boolean isminusNumber(int number){
        if (number < 0) {
            throw new RuntimeException();
        }
        return false;
    }
}