package step2;

import java.util.Objects;

public class Utils {
    public static boolean isNullOrEmpty(String string) {
        return Objects.isNull(string) || string.trim().isEmpty();
    }
}
