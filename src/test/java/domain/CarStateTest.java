package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStateTest {
    int defaultPosition = 3;
    int defaultMoveValue = 2;

    CarState defaultCarState;
    CarDisplacement defaultCarDisplacement;

    @BeforeEach
    void setUp() {
        defaultCarState = CarState.create(defaultPosition);
        defaultCarDisplacement = DefaultCarDisplacement.create(defaultMoveValue);
    }

    @Test
    void copy() {
        assertEquals(defaultCarState, defaultCarState.copy());
    }

    @Test
    void move() {
        assertEquals(CarState.create(defaultPosition + defaultMoveValue), defaultCarState.move(defaultCarDisplacement));
    }

    @Test
    void testEquals() {
        assertEquals(CarState.create(defaultPosition), defaultCarState);
    }

    @Test
    void testToString() {
        assertEquals(String.format("{position : %d}", defaultPosition), defaultCarState.toString());
    }
}
