package race.util;
import java.util.Random;

public class RandomNumberUtil {

    private static final Random RANDOM = new Random();
    public static final int BOUND = 10;

    public static int getRandomNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
