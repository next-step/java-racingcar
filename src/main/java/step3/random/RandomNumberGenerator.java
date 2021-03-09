package step3.random;

import java.util.Random;

/**
 * 숫자를 실제 생성하여 반환하는 클래스
 */
public class RandomNumberGenerator implements NumberGenerator {

    public static final int RANDOM_RANGE_BOUND = 10;
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_RANGE_BOUND);
    }
}
