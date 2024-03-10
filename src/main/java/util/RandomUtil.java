package util;

public class RandomUtil {

    private RandomUtil() {
    }

    public static int random() {
        return (int) (Math.random() * 10);
    }
}
