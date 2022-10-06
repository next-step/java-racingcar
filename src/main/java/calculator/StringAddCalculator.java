package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    /**
     * 기능 요구사항
     * <p>
     * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
     * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
     * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     */

    static String delimiter = ",|:";
    static String pattern = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (checkEmpty(input)) return 0;

        String[] tokens = tokenizer(input);

        return sum(tokens);
    }

    public static int sum(String[] tokens) throws RuntimeException{
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            validateNegative(num);
            sum += num;
        }
        return sum;
    }

    public static boolean checkEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static void validateNegative(int num) {
        if (num < 0) {
            throw new RuntimeException("negative number exception");
        }
    }

    public static String[] tokenizer(String input) {
        Matcher m = Pattern.compile(pattern).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(delimiter);
    }

}
