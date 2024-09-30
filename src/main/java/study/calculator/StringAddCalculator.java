package study.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
 * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
 * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
 * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
 * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
 * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
 */

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        } else {
            String[] values = splitNum(input);
            return sum(values);
        }
    }

    public static String[] splitNum(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = matcher.group(1); // ; 구분자
                input = matcher.group(2); // 1;2;3 추출
            }
        }
        return input.split(delimiter);
    }


    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }
}