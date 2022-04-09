package racing.model;

import java.util.Random;

public class CustomRandomImpl implements CustomRandom {
    private final Random random = new Random();

    @Override
    public int getRandomRange(int bound) {
        if (bound <= 1) {
            throw new IllegalArgumentException("1 보다 큰 수를 입력하세요.");
        }
        return random.nextInt(bound);
    }
}
