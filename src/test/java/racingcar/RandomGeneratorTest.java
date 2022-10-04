package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void randomInt() {
        int num = RandomGenerator.randomInt();
        assertThat(num).isBetween(0, 9);
    }
}