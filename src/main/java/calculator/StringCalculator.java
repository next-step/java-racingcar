package calculator;

import static java.util.Arrays.*;
import static java.util.Objects.isNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public int splitAndSum(String input) {
        if (isNotExist(input)) {
            return 0;
        }

        // 숫자가 하나인 경우에도 커스텀 관련 인풋은 인입될 수 있다는 가정하에
        // 계산 대상 숫자목록 추출작업후 1개 여부 관련 요구사항을 처리했습니다
        String[] targetNumbers = getNumbers(input);
        if (hasJustOneNum(targetNumbers)) {
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

    private boolean hasJustOneNum(String[] targetNumbers) {
        return targetNumbers.length == 1;
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

