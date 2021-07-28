package edu.nextstep.racingcar.step5.domain;

import java.util.Random;

public class DefaultMoveStrategy implements MoveStrategy {

    private static final int NUMBER_OF_RANDOMS = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isMove() {
        return new Random().nextInt(NUMBER_OF_RANDOMS) >= THRESHOLD;
    }
}
