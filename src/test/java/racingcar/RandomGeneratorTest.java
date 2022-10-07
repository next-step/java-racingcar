package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    void randomInt() {
        int num = RandomGenerator.randomInt();
        assertThat(num).isBetween(0, 9);
    }
}