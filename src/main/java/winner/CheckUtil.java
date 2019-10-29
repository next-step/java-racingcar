package winner;

import java.util.regex.Pattern;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 23:41
 */
public class CheckUtil {

    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");

    public static final boolean stringNullOrEmpty(String str) {
        return str == null || str.replaceAll(BLANK, EMPTY).isEmpty();
    }

    public static final boolean isNumber(String str) {
        return str != null && NUMERIC.matcher(str).matches();
    }

    public static final boolean greaterThanZero(int value) {
        return value > 0;
    }
}
