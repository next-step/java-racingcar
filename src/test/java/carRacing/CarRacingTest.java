package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
    }

    @Test
    void start() {
        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(-1, 2));

        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(6, 0));

        assertDoesNotThrow(() -> carRacing.start(2, 5));
    }
}