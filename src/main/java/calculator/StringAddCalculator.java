package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    static final Pattern CUNSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String value) {
        if(isNullOrEmpty(value )) return  0;

        if(value.contains("-")) throw new  RuntimeException();

        String[] array;
        Matcher matcher = CUNSTOM_PATTERN.matcher(value);
        if(matcher.find()) {
            array = separateTextWithCustomPattern(matcher);
        }else{
            array = value.split(DEFAULT_DELIMITER);
        }
        return  sum(array);
    }

    static boolean isNullOrEmpty(String value){
        return  value == null || value.isEmpty();
    }

    static String[] separateTextWithCustomPattern(Matcher matcher){

        String customDelimiter = matcher.group(1);
        String value = matcher.group(2);

        return value.split(customDelimiter);

    }

    
    static int sum(String[] valueArray){
        return Stream.of(valueArray).mapToInt(Integer::parseInt).sum();
    }

}
