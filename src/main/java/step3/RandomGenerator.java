package step3;

public class RandomGenerator {
    private RandomGenerator() {
    }

    public static int getLuckyNumber() {
        return (int) (Math.random() * 10);
    }
}
