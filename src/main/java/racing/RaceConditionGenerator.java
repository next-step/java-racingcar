package racing;

import java.util.Random;

public class RaceConditionGenerator {

    public static int randPositiveOrZero(int limit) {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);

        return random.nextInt(limit);
    }

    public static Boolean isGreaterThanEqualToBase(Integer base, Integer value) {
        int result = value.compareTo(base);
        return result >= 0;
    }

}
