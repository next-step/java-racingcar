package racingcar.util;

import java.util.Objects;
import java.util.function.Supplier;

public class Asserts {

    private Asserts() {
        throw new UnsupportedOperationException("Cannot invoke constructor \"Asserts()\"");
    }

    public static void notNull(Object nullInput, Supplier<String> exceptionMessage) {
        if (Objects.isNull(nullInput)) {
            throwIllegalArgumentExceptionWithMessage(exceptionMessage);
        }
    }

    public static void isTrue(boolean option, Supplier<String> exceptionMessage) {
        if (option) {
            return;
        }
        throwIllegalArgumentExceptionWithMessage(exceptionMessage);
    }

    public static void isFalse(boolean option, Supplier<String> exceptionMessage) {
        if (!option) {
            return;
        }
        throwIllegalArgumentExceptionWithMessage(exceptionMessage);
    }

    private static void throwIllegalArgumentExceptionWithMessage(Supplier<String> exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage.get());
    }

}
