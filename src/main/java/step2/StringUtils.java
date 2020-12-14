package step2;

import java.util.Objects;

public class StringUtils {
    public static boolean isNullOrEmpty(String string) {
        return Objects.isNull(string) || string.trim().isEmpty();
    }

    public static Integer parseStringToInt(String string) {
        return Integer.parseInt(string);
    }
}
