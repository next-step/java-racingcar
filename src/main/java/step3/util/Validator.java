package step3.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-04.
 * 검증 or Exception throw
 */
public class Validator {

    public static void checkArgumentInRange(int value, int min) {
        checkArgumentInRange(value, min, Integer.MAX_VALUE);
    }

    public static void checkArgumentInRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                    String.format("%s must be in range [%s, $s] and type of int", value, min, max));
        }
    }

    public static void checkEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()
                || "".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException("경주할 차 이름의 입력값이 없습니다.");
        }
    }

    public static void checkLength(String input, int length) {
        if (input.length() > length) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %s 자를 초과할 수 없습니다.", length));
        }
    }

}
