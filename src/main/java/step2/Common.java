package step2;

import java.util.Objects;

public class Common {

    public static boolean textNullOrEmpty(String text) {
        return Objects.isNull(text) || text.equals("");
    }
}
