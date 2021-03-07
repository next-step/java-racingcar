package racingcar.utils;

public class StringUtil {

    public static boolean isBlank(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static String repeat(String string, int times) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < times; ++i) {
            b.append(string);
        }
        return b.toString();
    }
}
