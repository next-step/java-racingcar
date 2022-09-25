package com.game.racing.generator;

public class NotMovableIntegerGenerator implements IntegerGenerator {

    private static final Integer NOT_MOVABLE_INTEGER = 2;

    @Override
    public Integer generate() {
        return NOT_MOVABLE_INTEGER;
    }
}
