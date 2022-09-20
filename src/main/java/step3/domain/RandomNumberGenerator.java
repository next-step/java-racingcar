package step3.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int bound;

    private final Random random = new Random();

    public RandomNumberGenerator(int bound) {
        validation(bound);
        this.bound = bound;
    }

    private void validation(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("0이하의 랜덤 값은 만들 수 없습니다.");
        }
    }

    @Override
    public int randomNumber() {
        return random.nextInt(bound);
    }
}
