package secondStage;

import secondStage.exception.EmptyException;
import secondStage.exception.NullException;

/**
 * split하는 클래스
 */
public class StringUtil {
    /**
     * 문자열 split
     */
    public static String[] split(String str) {
        validateNone(str);
        return str.split(" ");
    }

    /**
     * 문자열의 null, empty 예외
     */
    private static void validateNone(String str) {
        if (str == null) {
            throw new NullException();
        }

        if (str.isEmpty()) {
            throw new EmptyException();
        }
    }
}
