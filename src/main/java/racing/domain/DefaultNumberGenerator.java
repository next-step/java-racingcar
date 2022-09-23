package racing.domain;

import java.util.Random;

public class DefaultNumberGenerator implements NumberGenerator {

    private static int EXCEPTION_BOUND = 0;
    private final int bound;

    private final Random random = new Random();

    public DefaultNumberGenerator() {
        this(10);
    }

    public DefaultNumberGenerator(int bound) {
        validation(bound);
        this.bound = bound;
    }

    private void validation(int bound) {
        if (bound <= EXCEPTION_BOUND) {
            throw new IllegalArgumentException("0이하의 랜덤 값은 만들 수 없습니다.");
        }
    }

    @Override
    public int randomNumber() {
        return random.nextInt(bound);
    }
}
