package study03.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @Test
    @DisplayName("컨")
    void racing() {
        Racing racing = new Racing(3, 3);
        racing.start();
    }

}