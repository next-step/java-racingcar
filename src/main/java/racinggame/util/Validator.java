package racinggame.util;

import static calculator.domain.Constants.NUMERIC_REGEXP;
import static racinggame.util.Constants.*;

import java.util.regex.Pattern;

public class Validator {

    public static void validatePossibleToStart(String[] carNames) {
        if (carNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("참가자는 2명 이상입니다.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 글자 수는 5자 이하입니다.");
        }
    }

    public static void isNumber(String strNum) {
        Pattern numericPattern = Pattern.compile(NUMERIC_REGEXP);

        if (!numericPattern.matcher(strNum).matches()) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해주세요.");
        }
    }
}
