package calculator;

import calculator.constants.Operator;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Argument {

    private static final String REGEX = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]\\s+(\\d+))+$";
    private static final String SEPARATOR = " ";

    public static List<String> toList(String arg) throws IllegalArgumentException {

        if(!isValidArgument(arg)){
            throw new IllegalArgumentException("invalid argument format => " + arg);
        }

        return Arrays.stream(arg.split(SEPARATOR))
                .collect(Collectors.toList());
    }


    private static boolean isValidArgument(String arg){
        return !StringUtils.isEmpty(arg) && arg.matches(REGEX);
    }
}
