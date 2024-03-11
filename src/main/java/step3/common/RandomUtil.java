package step3.common;

public class RandomUtil {
    private RandomUtil() {
        throw new AssertionError();
    }

    public static int makeRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
