package racing.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Integer RANDOM_MAX = 9;
    private static final Integer RANDOM_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        int randomNumber = random.nextInt(RANDOM_BOUND);
        if (randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        return randomNumber;
    }

}
