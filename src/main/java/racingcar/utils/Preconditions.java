package racingcar.utils;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
    }

    public static void checkString(String reference, Object errorMessage) {
        if (reference == null || reference.length() == 0) {
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }

    public static void checkNumber(int request, int limit, Object errorMessage) {
        if (request <= limit) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}