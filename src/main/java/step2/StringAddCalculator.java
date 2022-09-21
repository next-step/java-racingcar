package step2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    /*
    기능 요구사항
    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     */
    public static int splitAndSum(String text) {
        String delimiters = ",|:";
        String[] tokens = {};
        int answer = 0;

        if (text  == null || text.isEmpty()) {
            return 0;
        }

        tokens = text.split(delimiters);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return getAnswer(tokens, answer);
    }

    private static int getAnswer(String[] tokens, int answer) {
        for (String token : tokens) {
            int x = Integer.parseInt(token);
            if (x < 0) {
                throw new RuntimeException();
            }
            answer += x;
        }
        return answer;
    }
}
