package camp.nextstep.edu.util;

public final class AssertUtils {
    private AssertUtils() {
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
