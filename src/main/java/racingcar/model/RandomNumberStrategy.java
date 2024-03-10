package racingcar.model;

import racingcar.interfaces.MoveStrategy;

import java.util.Random;

public class RandomNumberStrategy implements MoveStrategy {

    @Override
    public int getMoveNumber() {
        Random random = new Random();
        return new Random().nextInt(10);
    }
}
