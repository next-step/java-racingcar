package racing;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final Random random;

    private static final Integer RACE_CONDITION_NUM_LIMIT = 10;
    private static final Integer BASE_VALUE = 4;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    // 0 <= generated value < limit
    public Integer randPositiveOrZero(int limit) {
        return random.nextInt(limit);
    }

    public static Boolean isGreaterThanEqualToBase(Integer base, Integer value) {
        int result = value.compareTo(base);
        return result >= 0;
    }

    @Override
    public boolean isMovable() {
        return isGreaterThanEqualToBase(BASE_VALUE, randPositiveOrZero(RACE_CONDITION_NUM_LIMIT));
    }

}
