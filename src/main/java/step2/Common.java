package step2;

import java.util.Objects;

public class Common {

    public static boolean isTextNullOrEmpty(String text) {
        return Objects.isNull(text) || text.equals("");
    }
}
