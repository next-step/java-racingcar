package racingcar.validation;

import racingcar.exception.GameException;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UserInputValidator {

    public static final Pattern VALID_PATTERN = Pattern.compile("^[\\w]+(,[\\w]+)*$");

    public static void carNamesInputValidate(String carNamesInput, String defaultDelimiter) {
        nullOrEmptyCheck(carNamesInput);
        delimiterPatternCheck(carNamesInput);
        validateNameLength(carNamesInput, defaultDelimiter);
        duplicatedNamesCheck(carNamesInput, defaultDelimiter);
    }

    private static void delimiterPatternCheck(String carNamesInput) {
        if (!VALID_PATTERN.matcher(carNamesInput).matches()) {
            throw new GameException("자동차 이름을 올바르게 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    private static void validateNameLength(String numberInput, String defaultDelimiter) {
        for (String carName : numberInput.split(defaultDelimiter)) {
            String trimmed = carName.trim();
            if (trimmed.isEmpty() || trimmed.length() > 5) {
                throw new GameException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    private static void duplicatedNamesCheck(String numberInput, String defaultDelimiter) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : numberInput.split(defaultDelimiter)) {
            if (!uniqueCarNames.add(carName.trim())) {
                throw new GameException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public static void numberInputValidate(String numberInput) {
        nullOrEmptyCheck(numberInput);
        numberFormatCheck(numberInput);
        positiveNumberCheck(numberInput);
    }

    private static void nullOrEmptyCheck(String carCount) {
        if (carCount == null || carCount.isBlank()) {
            throw new GameException("올바른 입력값이 아닙니다.");
        }
    }

    private static void numberFormatCheck(String numberInput) {
        try {
            Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new GameException("숫자만 가능합니다.");
        }
    }

    private static void positiveNumberCheck(String numberInput) {
        if (Integer.parseInt(numberInput) < 0) {
            throw new GameException("양수를 입력해주세요.");
        }
    }


}
