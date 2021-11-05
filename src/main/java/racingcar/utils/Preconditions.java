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

    public static void checkMinimumSize(int request, int minimumSize, Object errorMessage) {
        if (request <= minimumSize) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkMaximumSize(int request, int maximumSize, Object errorMessage) {
        if (request >= maximumSize) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}