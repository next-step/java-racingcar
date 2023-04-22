package positiveinteger;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final static String DEFAULT_DELIMITER = "[,|:]";
    private final static Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public int calculate(String expression){
        if(expression == null || expression.isEmpty()){
            return 0;
        }

        Matcher matcher = PATTERN.matcher(expression);
        if(matcher.find()){
            return calculate(matcher.group(2), matcher.group(1));
        }

        return calculate(expression, DEFAULT_DELIMITER);
    }

    private int calculate(String expression, String delimiter){
        return Arrays.stream(expression.split(delimiter))
                .map(PositiveInteger::from)
                .mapToInt(PositiveInteger::getValue)
                .sum();
    }

}
