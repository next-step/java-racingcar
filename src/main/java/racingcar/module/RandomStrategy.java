package racingcar.module;

import static racingcar.Constant.INPUT_RANDOM_NUM;

public class RandomStrategy implements MovingStrategy {
    private final RandomNumberGenerator random = new RandomNumberGenerator();

    @Override
    public boolean isMove() {
        return random.getRandomNum() >= INPUT_RANDOM_NUM;
    }


}