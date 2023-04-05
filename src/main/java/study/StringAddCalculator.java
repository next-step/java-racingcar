package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]*$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String inputText) {

        //  1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
        if (checkEmpty(inputText)) {
            return 0;
        }

        //  2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
        if (inputText.length() == 1) {
            return parseFormat(inputText);
        }

        //  3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
        //  4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.
        //  5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.
        //  6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.
        return sumNumbers(splitText(inputText));
    }

    private boolean checkEmpty(String text) {

        //  나중에는 StringUtils.hasText() 사용하면 될 것 같다고 생각이 든다.
        return text == null || text.isEmpty();
    }

    private int parseFormat(String text) {

        if (!ONLY_NUMBER.matcher(text).find()) {
            throw new NumberFormatException();
        }

        return Integer.parseInt(text);
    }

    private String[] splitText(String text) {
        if (isMatchCustomPattern(text)) {
            return splitCustomPattern(text);
        }

        return text.split(",|:");
    }

    private boolean isMatchCustomPattern(String text) {
        return CUSTOM_PATTERN.matcher(text).find();
    }

    private String[] splitCustomPattern(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        //  matcher 에 안 걸리는 경우는...?
        return null;
    }

    private int sumNumbers(String[] numbers) {

        if(checkNegativeNumber(numbers)) {
            return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        }

        throw new RuntimeException();
    }

    private boolean checkNegativeNumber(String[] numbers) {

        if(Arrays.stream(numbers).allMatch(number -> Integer.parseInt(number) > 0)) {
            return true;
        }

        return false;
    }
}
