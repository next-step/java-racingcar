package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String EXCEPTION_MSG = "음수는 입력이 불가합니다.";

    public static int splitAndSum(String inData) {
        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
        if (inData == null || inData.isEmpty()) {
            return 0;
        }

        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
        if (inData.length() == 1) {
            int num = Integer.parseInt(inData);
            return num;
        }

        // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(inData);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sumStringArray(tokens);
        }
        return sumStringArray(splitInputString(inData));
    }

    private static String[] splitInputString(String inData) {
        // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
        // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
        String[] splitVal = inData.split(",|:");

        // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
        if (Arrays.toString(splitVal).contains("-")) {
            throw new RuntimeException(EXCEPTION_MSG);
        }
        return splitVal;
    }

    private static int sumStringArray(String[] tokens) {
        int result = 0;

        for (String s : tokens) {
            int num = Integer.parseInt(s);
            result += num;
        }

        return result;
    }

}
