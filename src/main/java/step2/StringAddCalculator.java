package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REG_EXP = "//(.)\n(.*)";

    public static int splitAndSum(String input) {

        if(isEmpty(input)){
            return 0;
        }

        String[] splitNumbers = splitNumbers(input);

        validateNumbers(splitNumbers);

        return sum(splitNumbers);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitNumbers(String input) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REG_EXP).matcher(input);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(customDelimiter);
        }

        return input.split(DELIMITER);
    }

    private static void validateNumbers(String[] splitNumbers) {
        validateNegativeNumbers(splitNumbers);
    }

    private static void validateNegativeNumbers(String[] splitNumbers) {
        for(int i = 0; i < splitNumbers.length ; i++){
            validateNegativeNumber( Integer.parseInt(splitNumbers[i]) );
        }
    }

    private static void validateNegativeNumber(int number){
        if(isNegative(number)){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static int sum(String[] splitNumber) {
        return Arrays.stream(splitNumber)
                .mapToInt(number -> Integer.parseInt(number))
                .sum();
    }
}
