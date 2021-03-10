package racingcar.module;

import racingcar.Constant;
import racingcar.module.MovingStrategy;

import java.util.Random;

import static racingcar.Constant.INPUT_RANDOM_NUM;
import static racingcar.Constant.MAX_RANDOM_NUM;

public class RandomStrategy implements MovingStrategy {



    @Override
    public boolean isMove() {
        return new Random().nextInt(MAX_RANDOM_NUM) >= INPUT_RANDOM_NUM;
    }


}