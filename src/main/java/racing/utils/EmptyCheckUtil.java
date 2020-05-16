package racing.utils;

import java.util.List;
import java.util.Objects;

public class EmptyCheckUtil {

    public static void emptyCheck(String arguments) {
        if (Objects.isNull(arguments) || arguments.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(List arguments) {
        if (Objects.isNull(arguments)) {
            throw new IllegalArgumentException();
        }

        if (arguments.size() < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(Object arguments) {
        if (Objects.isNull(arguments)) {
            throw new IllegalArgumentException();
        }
    }
}
