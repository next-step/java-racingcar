package carracing;

import org.junit.jupiter.api.Test;

import static carracing.CarRacing.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    @Test
    void normalReturn() {
        assertThat(carInputProcess("1")).isEqualTo(1);
    }

    @Test
    void nullOrBlank() {
        assertThat(carInputProcess("")).isEqualTo(0);
    }
}
