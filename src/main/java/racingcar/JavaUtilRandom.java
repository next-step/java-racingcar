package racingcar;

public class JavaUtilRandom implements RandomUtil {
    private static final JavaUtilRandom INSTANCE = new JavaUtilRandom();
    private final java.util.Random RANDOM;

    private JavaUtilRandom() {
        RANDOM = new java.util.Random();
    }

    public static JavaUtilRandom getInstance() {
        return INSTANCE;
    }

    public int getInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
