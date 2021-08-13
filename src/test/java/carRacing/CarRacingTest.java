package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private CarRacing carRacing;
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
        carNames = Arrays.asList("star", "jae", "hong");
    }

    @Test
    void start() {
        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(null, 2));

        assertThatIllegalArgumentException().isThrownBy(() -> carRacing.start(carNames, 0));

        assertDoesNotThrow(() -> carRacing.start(carNames, 5));
    }
}