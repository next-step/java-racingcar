package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
    }

    @Test
    void start() {
        assertDoesNotThrow(() -> {
            carRacing.start(2, 5);
        });
    }
}