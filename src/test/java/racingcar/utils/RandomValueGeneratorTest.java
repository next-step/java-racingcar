package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RandomValueGenerator.randomForward;

class RandomValueGeneratorTest {
    @Test
    void 임의조건으로_랜덤발생() {
        assertThat(randomForward()).isGreaterThanOrEqualTo(0);
    }
}