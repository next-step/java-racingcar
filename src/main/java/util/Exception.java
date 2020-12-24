package util;

public class Exception {
    public static void illegalArgumentException(String msg) {
        throw new IllegalArgumentException(msg);
    }
    public static void nullPointerException(String msg) {
        throw new NullPointerException(msg);
    }
}
