package racing.utils;

import java.util.List;
import java.util.Objects;

public class EmptyCheckUtil {
    private static final int MIN_SIZE = 1;

    public static void emptyCheck(String argument) {
        if (Objects.isNull(argument) || argument.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(List argument) {
        if (Objects.isNull(argument)) {
            throw new IllegalArgumentException();
        }

        if (argument.size() < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(Object argument) {
        if (Objects.isNull(argument)) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyCheck(Object[] argument) {
        if (Objects.isNull(argument)) {
            throw new IllegalArgumentException();
        }

        if (argument.length < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
