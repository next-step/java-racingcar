package com.jaenyeong.mission2.racingcar.domain;

public class Distance {
    private static final int STOP = 0;
    private final MoveStrategy move;
    private final int dist;

    public Distance() {
        this(STOP, MoveStrategy::moveForRandom);
    }

    public Distance(final MoveStrategy ms) {
        this.dist = STOP;
        this.move = ms;
    }

    private Distance(final int newDistance, final MoveStrategy ms) {
        this.dist = newDistance;
        this.move = ms;
    }

    public Distance move() {
        final int nextMove = nextMove();
        return new Distance(this.dist + nextMove, this.move);
    }

    private int nextMove() {
        final int valueForMoveToNext = moveForStrategy();

        return (valueForMoveToNext >= Move.MOVE_LIMIT_WHEN_RANDOM.getValue())
            ? Move.NEXT.getValue()
            : Move.STOP.getValue();
    }

    private int moveForStrategy() {
        return move.move();
    }

    public int getDist() {
        return dist;
    }
}
