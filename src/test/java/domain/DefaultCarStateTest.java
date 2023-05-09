package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCarStateTest {
    int defaultPosition = 3;
    int defaultMoveValue = 2;

    DefaultCarState defaultDefaultCarState;
    CarDisplacement defaultCarDisplacement;

    @BeforeEach
    void setUp() {
        defaultDefaultCarState = DefaultCarState.create(defaultPosition);
        defaultCarDisplacement = DefaultCarDisplacement.create(defaultMoveValue);
    }

    @Test
    void copy() {
        assertEquals(defaultDefaultCarState, defaultDefaultCarState.copy());
    }

    @Test
    void move() {
        assertEquals(DefaultCarState.create(defaultPosition + defaultMoveValue), defaultDefaultCarState.move(defaultCarDisplacement));
    }

    @Test
    void testEquals() {
        assertEquals(DefaultCarState.create(defaultPosition), defaultDefaultCarState);
    }

    @Test
    void testToString() {
        assertEquals(String.format("{position : %d}", defaultPosition), defaultDefaultCarState.toString());
    }
}
