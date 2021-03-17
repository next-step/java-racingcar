package step3.study.util;

public class StringUtils {
    public static String[] split(String str, String regex) {
        return str.split(regex);
    }

    public static String repeat(String str, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(str);
        }
        return result.toString();
    }
}
