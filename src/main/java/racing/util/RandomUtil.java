package racing.util;

public class RandomUtil {

    private static final int maximumValue = 9;

    public static int randomValue() {
        return (int)(Math.random() * maximumValue);
    }
}
