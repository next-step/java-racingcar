package racingCarGame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCarGame.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    @DisplayName("RandomGenerator의 getCarRandomInt(10)는 0 ~ 9를 반환한다.")
    void getCarRandomInt() {
        assertThat(RandomGenerator.getCarRandomInt(10))
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
