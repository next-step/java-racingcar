package study;

public class StringUtils {

    public static Boolean isEmpty(String s) {
        if (s == null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static Boolean isBlank(String s) {
        if (!isEmpty(s) && s.trim().length() > 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
