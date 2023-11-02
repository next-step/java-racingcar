package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static Matcher patternMatcher(String input) {
        return Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    private static String findDelimiter (String input) {
        String delimiter = ",|:";

        Matcher m = patternMatcher(input);

        if ( m.find() ) {
            return m.group(1);
        }
        return delimiter;
    }

    private static int getSize(String input) {
        String delimiter = ",|:";

        if( input == null || "".equals(input) ){
            return 0;
        }

        return input.split(findDelimiter(input)).length;
    }

    public static int splitAndSum (String input) {
        int sum = 0;

        if ( getSize(input) == 0 ) {
            return 0;
        }

        if ( getSize(input) == 1 ) {
            return Integer.parseInt(input);
        }

        if( input.contains("-") ) {
            throw new RuntimeException();
        }

        String[] tokens = input.split(findDelimiter(input));
        Matcher m = patternMatcher(input);

        if(m.find()){
            tokens = m.group(2).split(findDelimiter(input));
        }

        for (int i=0; i < tokens.length; i++ ) {
            sum += Integer.parseInt(tokens[i]);
        }

        return sum;
    }
}
