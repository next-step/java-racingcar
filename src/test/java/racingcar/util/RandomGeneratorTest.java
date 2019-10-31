package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 생성 시 bound 내에서만 생성된다.")
    void getRandomInteger() {
        int bound = 10;

        int result = RandomGenerator.getRandomInteger(bound);

        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(9);
    }
}
