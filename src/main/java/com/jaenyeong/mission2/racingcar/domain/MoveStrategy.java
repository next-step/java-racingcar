package com.jaenyeong.mission2.racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

@FunctionalInterface
public interface MoveStrategy {
    int move();

    static int moveForRandom() {
        return ThreadLocalRandom.current()
            .nextInt(Move.RANDOM_START_RANGE.getValue(), Move.RANDOM_END_RANGE.getValue());
    }
}
