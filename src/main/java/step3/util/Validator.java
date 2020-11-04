package step3.util;

/**
 * Created By mand2 on 2020-11-04.
 * 검증 or Exception throw
 */
public class Validator {

    public static void checkArgumentInRange(int value, int min) {
        if (value < min) {
            throw new IllegalArgumentException(
                    String.format("%s must be in range [%s, ] and type of int", value, min));
        }
    }

}
