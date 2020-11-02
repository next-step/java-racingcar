package step3.util;

public class RandomGenerator {
    private RandomGenerator() {
    }

    public static double getRandomLessThan(int number) {
        return Math.random() * number;
    }
}
