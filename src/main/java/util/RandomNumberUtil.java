package util;

public final class RandomNumberUtil {
    private RandomNumberUtil() {}

    public static int getRandomNumberFromZeroToNine() {
        return (int) (Math.random() * 10);
    }
}
