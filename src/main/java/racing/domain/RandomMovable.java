package racing.domain;

import java.util.Random;

public class RandomMovable implements Movable {

    private static final Integer MOVE_MIN = 4;
    private static final Integer RANDOM_MAX = 9;
    private static final Integer RANDOM_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return getRandom() >= MOVE_MIN;
    }

    private int getRandom() {
        int randomNumber = random.nextInt(RANDOM_BOUND);
        if (randomNumber < 0 || randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        return randomNumber;
    }

}
