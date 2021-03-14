package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @DisplayName("0 ~ 9 사이의 난수를 발생시킨다")
    @Test
    void testRandomGenerator() {
        assertThat(RandomGenerator.getRandomValue()).isBetween(0, 9);
    }
}
