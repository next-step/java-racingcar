package calculator;

import calculator.constants.Operator;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Argument {

    private static final String REGEX = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]\\s+(\\d+))+$";
    private static final Pattern pattern = Pattern.compile(REGEX);
    private static final String SEPARATOR = " ";

    private Argument(){
        throw new AssertionError();
    }

    public static List<String> stringExpressionToList(String expression) throws IllegalArgumentException {

        if(!isValidArgument(expression)){
            throw new IllegalArgumentException("invalid argument format => " + expression);
        }

        return Arrays.stream(expression.split(SEPARATOR))
                .collect(Collectors.toList());
    }


    private static boolean isValidArgument(String arg){
        return !StringUtils.isEmpty(arg) && pattern.matcher(arg).matches() && existAllSymbol(arg);
    }

    private static boolean existAllSymbol(String arg) {
        return arg.contains(Operator.PLUS.getSymbol()) &&
                arg.contains(Operator.MINUS.getSymbol()) &&
                arg.contains(Operator.DIVIDE.getSymbol()) &&
                arg.contains(Operator.MULTIPLY.getSymbol());
    }
}
