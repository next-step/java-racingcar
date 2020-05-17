package racing.utils;

import java.util.List;
import java.util.Objects;

public class EmptyCheckUtil {

    public static void emptyCheck(String argument) {
        if (Objects.isNull(argument) || argument.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(List argument) {
        if (Objects.isNull(argument)) {
            throw new IllegalArgumentException();
        }

        if (argument.size() < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(Object argument) {
        if (Objects.isNull(argument)) {
            throw new IllegalArgumentException();
        }
    }
}
