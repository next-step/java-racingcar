package racingcar.utils;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    public static void checkNumber(int request, int limit, Object errorMessage) {
        if (request <= limit) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}