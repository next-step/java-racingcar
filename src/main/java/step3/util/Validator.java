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

}
