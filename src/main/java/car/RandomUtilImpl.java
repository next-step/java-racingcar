package car;

import java.util.Random;

public class RandomUtilImpl implements RandomUtil {
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
