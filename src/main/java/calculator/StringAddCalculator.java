package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.InputParser;
import util.StringUtil;

public class StringAddCalculator {
    /*
    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

    * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    * */

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
    private static final int DELIMETER_GROUP = 1;
    private static final int TOKENS_GROUP = 2;

    public static String[] getNumbers(String inputText) {
        // 너무 한 메소드에 리턴이 많은 것 같아서 찜찜합니다..
        if (StringUtil.isBlank(inputText)) {
            return new String[]{"0"};
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(DELIMETER_GROUP);
            // 이 부분 코드에 왠지 자신이 없습니다..
            return m.group(TOKENS_GROUP).split(DEFAULT_DELIMITER.concat("|" + customDelimiter));
        }

        return inputText.split(DEFAULT_DELIMITER);
    }

    public static int splitAndSum(String inputText) {
        String[] tokens = getNumbers(inputText);

        return Arrays.stream(tokens).mapToInt(s -> {
            int number = InputParser.stringToInteger(s);
            InputParser.isPositive(number);
            return number;
        }).sum();
    }
}
