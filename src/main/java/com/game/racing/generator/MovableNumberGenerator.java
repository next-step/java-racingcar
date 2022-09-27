package com.game.racing.generator;

public class MovableNumberGenerator implements NumberGenerator {

    private static final Integer MOVABLE_INTEGER = 5;

    @Override
    public Integer generate() {
        return MOVABLE_INTEGER;
    }
}
