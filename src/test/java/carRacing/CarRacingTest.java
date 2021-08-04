package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;
    private String[] carNames;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
        carNames = new String[]{"star", "jae", "hong"};
    }

    @Test
    void start() {
        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(null, 2));

        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(carNames, 0));

        assertDoesNotThrow(() -> carRacing.start(carNames, 5));
    }
}