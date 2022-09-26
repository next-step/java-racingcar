package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarPositionTest {

    @Test
    void shouldValidateCarPosition_whenPositionNegative() {
        assertThrows(IllegalArgumentException.class, () -> new CarPosition(-1));
    }

    @Test
    void shouldValidateCarPosition_normalCond() {
        assertDoesNotThrow(() -> new CarPosition(0));
    }
}

