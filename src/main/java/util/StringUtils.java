package util;

/**
 * @author : yusik
 * @date : 2019/10/25
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

}
