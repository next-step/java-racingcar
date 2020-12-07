package com.jaenyeong.mission2.racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Distance {
    public static final int STOP = 0;
    private final int dist;

    public Distance() {
        this.dist = STOP;
    }

    private Distance(final int newDistance) {
        this.dist = newDistance;
    }

    public Distance move() {
        final int nextMove = nextMove();
        return new Distance(this.dist + nextMove);
    }

    private int nextMove() {
        final int valueForMoveToNext = ThreadLocalRandom.current()
            .nextInt(Move.RANDOM_START_RANGE.getValue(), Move.RANDOM_END_RANGE.getValue());

        return (valueForMoveToNext >= Move.MOVE_LIMIT_WHEN_RANDOM.getValue())
            ? Move.NEXT.getValue()
            : Move.STOP.getValue();
    }

    public int getDist() {
        return dist;
    }
}
