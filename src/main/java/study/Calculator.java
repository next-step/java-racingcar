package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Calculator {

    final static String REG_EXP = "[,:]";
    final static String CUSTOM_REG_EXP = "^//(.)\n(.*)";

    public static int splitAndSum(String splitTarget) {
        int sum = 0;
        if(splitTarget == null || splitTarget.isEmpty()) {
            return sum;
        }

        Matcher matcher = Pattern.compile(CUSTOM_REG_EXP).matcher(splitTarget);
        if(matcher.find()) {
            String separator = matcher.group(1);
            String targetNumbers = matcher.group(2);

            return getSum(targetNumbers, separator);

        }
        return getSum(splitTarget, REG_EXP);
    }

    private static int getSum(String numbers, String separator) {
        int sum = 0;
        String[] splitNumbers = numbers.split(separator);
        for(String stringNumber : splitNumbers) {
            int number = getNumber(stringNumber);
            if(number < 0) {
                throw new RuntimeException("음수는 허용하지 않습니다.");
            }
            sum += number;
        }
        return sum;
    }

    private static int getNumber(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

}
