package study.first;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str == "" || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEvenInputLength(int length) {
        return length % 2 == 0;
    }
}
