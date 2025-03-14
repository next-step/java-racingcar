package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELEMETER = "[,:]";
    public static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
        if (isBlank(input)) {
            return 0;
        }
        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
        // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
        // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
        // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
        // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
        return sum(toInts(split(input)));

    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(REGEX).matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(DEFAULT_DELEMETER);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }
    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if(number < 0){
            throw new RuntimeException("음수를 허용하지 않습니다.");
        }
        return number;
    }
}

