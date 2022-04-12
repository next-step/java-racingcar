package me.devyonghee.racingcar.utility;

public final class Assert {

    private Assert() {
        throw new AssertionError();
    }

    public static <T> void notNull(T object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasText(String text, String message) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
