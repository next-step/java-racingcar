package racingcar.util;

import java.util.Objects;
import java.util.function.Supplier;

public class Asserts {

    public static void notNull(Object nullInput, Supplier<String> exceptionMessage) {
        if (Objects.isNull(nullInput)) {
            throw new IllegalArgumentException(exceptionMessage.get());
        }
    }

    public static void isTrue(boolean option, Supplier<String> exceptionMessage) {

    }
}
