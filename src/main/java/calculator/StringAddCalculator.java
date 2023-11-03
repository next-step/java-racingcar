package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    private static final Pattern CUNSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITERS = ",|:";

    private StringAddCalculator(){
        throw new IllegalStateException("Utility Class");
    }


    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) return  0;

        if(isNegativeNumber(text)) throw new  RuntimeException();

        Matcher m = CUNSTOM_PATTERN.matcher(text);

        String delimiter = findDelimiter(m);

        if(isCustomDelimiter(delimiter)){
            text = m.group(2);
        }

        return  sum(splitText(text, delimiter));
    }

    private static boolean isNullOrEmpty(String text){
        return  text == null || text.isEmpty();
    }

    private static boolean isNegativeNumber(String text) {
        return text.contains("-");
    }

    private static boolean isCustomDelimiter(String delimiter) {
        return !delimiter.equals(DEFAULT_DELIMITERS);
    }

    private static String findDelimiter(Matcher m) {

        if (m.find()) {
            return DEFAULT_DELIMITERS + '|' + m.group(1);
        }
        return DEFAULT_DELIMITERS;
    }

    private static String[] splitText(String text, String delimiter){
        return  text.split(delimiter);
    }
    
    private static int sum(String[] textArray){
        return Stream.of(textArray).mapToInt(Integer::parseInt).sum();
    }

}
