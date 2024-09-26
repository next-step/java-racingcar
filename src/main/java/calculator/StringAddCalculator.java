package calculator;

import calculator.exception.StringAddException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {

    public static int splitAndSum(String exp) {

        // 빈 문자열 또는 null값을 입력할 경우 0을 반환한다.
        if (validateInputValue(exp)) {
            return 0;
        }

        // 구분자로 split 하여 String[] 을 반환한다.
        String[] strNumbers = splitNumbers(exp);
        isValidNumber(strNumbers);

        return addNumber(strNumbers);
    }

    private static void isValidNumber(String[] strNumbers) {
        for (String number : strNumbers) {
            // 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
            if(!isPositiveNumber(number)) {
                throw new StringAddException("숫자 이외의 값 또는 음수를 입력하였습니다.");
            }
        }
    }

    private static boolean isPositiveNumber(String number) {
        // 음수인 경우도 '-' 가 포함되어 있어 false로 반환한다.
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private static boolean validateInputValue(String exp) {
        return exp == null || exp.isEmpty();
    }

    private static String[] splitNumbers(String exp) {
        String delimiterPattern = "//(.)\n(.*)";
        Matcher m = Pattern.compile(delimiterPattern).matcher(exp);

        // 커스텀 구분자를 사용한 경우
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        // 구분자로 [,] [:]를 사용한 경우
        return exp.split(",|:");
    }

    private static int addNumber(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}