package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 덧셈 계산기.
 * <p>
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * <p>
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * <p>
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
public class StringSumCalculator {
    public static final String DEFAULT_DELIMITER = "[,:]";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        return sum(toInt(split(text)));
    }

    private static String[] split(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int[] toInt(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0 ; i < numbers.length; i ++) {
            result[i] = toInt(numbers[i]);
        }
        return result;
    }

    private static int toInt(String number) {
        int result = Integer.parseInt(number);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
