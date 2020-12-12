package racingcar.util;

public class ValidateUtil {
    private static final int MIN_NO = 1;
    public static boolean validateMin(int no) {
        return no < MIN_NO;
    }
}
