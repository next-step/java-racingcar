package com.game.racing.domain.generator;

public class NotMovableNumberGenerator implements NumberGenerator {

    private static final Integer NOT_MOVABLE_INTEGER = 2;

    @Override
    public Integer generate() {
        return NOT_MOVABLE_INTEGER;
    }
}
