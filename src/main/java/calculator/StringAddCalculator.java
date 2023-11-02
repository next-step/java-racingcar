package calculator;

import java.util.Arrays;
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
        if(isNullOrEmpty(text )) return  0;

        if(text.contains("-")) throw new  RuntimeException();

        String[] array = splitText(text);

        return  sum(array);
    }
    private static boolean isNullOrEmpty(String text){
        return  text == null || text.isEmpty();
    }

    private static String[] splitText(String text){
        Matcher m = CUNSTOM_PATTERN.matcher(text);

        String delimiter = findDelimiter(m);

        if(!delimiter.equals(DEFAULT_DELIMITERS)){
            text = m.group(2);
        }
        return  text.split(delimiter);
    }


    private static String findDelimiter(Matcher m) {

        if (m.find()) {
            return DEFAULT_DELIMITERS + '|' + m.group(1);
        }
        return DEFAULT_DELIMITERS;
    }


    private static int sum(String[] textArray){
        return Stream.of(textArray).mapToInt(Integer::parseInt).sum();
    }

}
