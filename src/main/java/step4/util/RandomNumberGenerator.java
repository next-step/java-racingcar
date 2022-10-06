package step4.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_BOUND_NUMBER = 10;

    private static final Random random = new Random();

    private static void checkBoundCondition(int bound) {
        if (bound > MAX_BOUND_NUMBER) throw new RuntimeException("생성될 수 있는 숫자의 범위를 초과하였습니다.");
    }

    @Override
    public int generateNumber(int bound) {
        checkBoundCondition(bound);
        return random.nextInt(bound);
    }
}
