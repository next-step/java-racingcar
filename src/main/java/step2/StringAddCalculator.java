package step2;

import step2.exception.NotPositiveIntegerException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String ZERO_TO_NINE_FORMAT = "^[0-9]*$";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");


    public static int splitAndSum(String numbersString) {

        if (isEmpty(numbersString)) return 0;

        if (isOnlyOneNumber(numbersString)) return Integer.parseInt(numbersString);

        return getSumNumbers(split(numbersString));

    }

    /**
     * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
     *
     * @param text
     * @return
     */
    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    /**
     * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
     *
     * @param text
     * @return
     */
    private static boolean isOnlyOneNumber(String text) {
        return text.matches(ZERO_TO_NINE_FORMAT) && text.length() == 1;
    }

    /**
     * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
     * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
     * @param text
     * @return
     */
    private static String[] split(String text) {
        if (isMatchCustomDelimiter(text)) return splitUsingCustomDelimiter(text);
        return text.split("[,:]");
    }

    /**
     * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
     *
     * @param text
     * @return
     */
    private static String[] splitUsingCustomDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    /**
     * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
     *
     * @param number
     * @return
     */
    private static boolean isPositiveInteger(int number) {
        return number > -1;
    }

    /**
     * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     *
     * @param number
     * @return
     */
    private static boolean isPositiveInteger(String number) {
        return number.matches(ZERO_TO_NINE_FORMAT);
    }

    /**
     * “//”와 “\n” 문자 사이에 커스텀 구분자 여부 확인
     *
     * @param text
     * @return
     */
    private static boolean isMatchCustomDelimiter(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text).find();
    }

    /**
     * 숫자 합
     * @param numbers
     * @return
     */
    private static int getSumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {

            // 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
            /*
            int n = Integer.parseInt(number);
            if (!isPositiveInteger(n))
                throw new NotPositiveIntegerException("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)");
            result += n;
            */

            // 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
            if (!isPositiveInteger(number))
                throw new NotPositiveIntegerException("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.");
            result += Integer.parseInt(number);

        }
        return result;
    }

}
