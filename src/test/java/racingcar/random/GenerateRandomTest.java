package racingcar.random;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.random.GenerateRandom.randomForward;

class GenerateRandomTest {
    @Test
    void 임의조건으로_랜덤발생() {
        assertThat(randomForward()).isGreaterThanOrEqualTo(0);
    }
}