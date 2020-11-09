package racingcar.domain;

import racingcar.domain.utils.Number;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {

    @Override
    public int move() {
        return new Random().nextInt(Number.RANDOM_MAX_VALUE);
    }
}
