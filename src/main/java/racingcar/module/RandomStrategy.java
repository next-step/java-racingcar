package racingcar.module;

import racingcar.Constant;
import racingcar.module.MovingStrategy;

import java.util.Random;

import static racingcar.Constant.INPUT_RANDOM_NUM;
import static racingcar.Constant.MAX_RANDOM_NUM;

public class RandomStrategy implements MovingStrategy {
    private final GenerateRandomNumber random = new GenerateRandomNumber();

    @Override
    public boolean isMove() {
        return random.getRandomNum() >= INPUT_RANDOM_NUM;
    }


}