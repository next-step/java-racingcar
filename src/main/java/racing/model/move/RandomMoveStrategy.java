package racing.model.move;

import racing.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int LEAST_NUM = 4;

    @Override
    public boolean move() {
        int randomNumber = RandomUtil.getRandomValue();

        if (randomNumber >= LEAST_NUM) {
            return true;
        }

        return false;
    }
}
