package calculator;

import static java.util.Arrays.*;
import static java.util.Objects.isNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";


    // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0) -> 처리
    // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

    public int sum(String input) {
        if (isNotExist(input)) {
            return 0;
        }

        String[] targetNumbers = getNumbers(input);
        if (hasJustOneNum(input)) {
            return processOneNumber(targetNumbers[0]);
        }

        return stream(targetNumbers)
                .mapToInt(this::processOneNumber)
                .sum();
    }

    private int processOneNumber(String targetNumber) {
        if (isNotDigit(targetNumber)) {
            throw new RuntimeException("입력값은 숫자여야 합니다");
        }

        int number = toInt(targetNumber);

        if (isNotPositive(number)) {
            throw new RuntimeException("입력값은 양수여야 합니다");
        }

        return number;
    }

    private String[] getNumbers(String input) {
        Matcher matcherResult = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcherResult.find()) {
            String delimiter = getCustomDelimiter(matcherResult);
            String numbers = polishInput(matcherResult);

            return numbers.split(delimiter);
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private String getCustomDelimiter(Matcher matcherResult) {
        return matcherResult.group(1);
    }

    private String polishInput(Matcher matcherResult) {
        return matcherResult.group(2);
    }

    private boolean hasJustOneNum(String input) {
        return input.length() == 1;
    }

    private boolean isNotExist(String input) {
        return isNull(input) || input.isBlank();
    }

    private boolean isNotPositive(int input) {
        return input < 0;
    }

    private boolean isNotDigit(String input) {
        return !Character.isDigit(input.charAt(0));
    }
}

