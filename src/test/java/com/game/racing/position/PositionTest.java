package com.game.racing.position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position position;

    @BeforeEach
    void set_up() {
        position = new Position();
        Position.resetMaxValue();
    }

    @Test
    void position_add() {
        position.add();
        assertEquals(1, position.get());
    }

    @Test
    void position_compare_and_get_max_value() {
        position.add();
        position.add();
        assertEquals(2, Position.getMaxValue());
    }
}