package step3.util;

public class RandomGenerator {
    private RandomGenerator() {
    }

    public static int getLuckyNumber() {
        return (int) (Math.random() * 10);
    }
}
