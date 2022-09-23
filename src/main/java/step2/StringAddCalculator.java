package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
기능 요구사항
쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

1. 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
2. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
3. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
4. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
5. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
6.  “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
7. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”) 구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.
 */
public class StringAddCalculator {

    public static final String COMMA_SEPARATOR = "[,:]";
    public static final String PATTERN = "//(.)\n(.*)";


    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int[] numbers = toInts(split(text));
        if (numbers.length == 1) {
            return numbers[0];
        }

        return sum(numbers);
    }


    private static String[] split(String text) {

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile(PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(COMMA_SEPARATOR);
    }

    private static int[] toInts(String[] values){
        return Arrays.stream(values).mapToInt(Integer::parseInt).map(StringAddCalculator::checkPositiveNumber).toArray();
    }

    private static int checkPositiveNumber(int num) {
        if (num < 0) throw new RuntimeException();
        return num;
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
