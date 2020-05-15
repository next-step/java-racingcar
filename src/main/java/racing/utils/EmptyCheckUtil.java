package racing.utils;

import java.util.Objects;

public class EmptyCheckUtil {

    public static void emptyCheck(String arguments) {
        if (Objects.isNull(arguments) || arguments.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
