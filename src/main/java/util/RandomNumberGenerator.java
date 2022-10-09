package util;

public final class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static int range(int min, int max) {
        return (int) (Math.random()*(max - min + 1) + min);
    }
}
