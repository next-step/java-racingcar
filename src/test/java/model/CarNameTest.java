package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void shouldValidateCarName_whenCarNameIsLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CarName("longName"));
    }

    @Test
    void shouldValidateCarName_whenNormalCond() {
        Assertions.assertDoesNotThrow(() -> new CarName("devcs"));
    }
}
