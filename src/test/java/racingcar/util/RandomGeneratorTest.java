package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @DisplayName("범위에 맞는 숫자 생성 여부 확인")
    @Test
    void RandomNumberTest() {
        assertThat(RandomGenerator.getNumber())
                .isLessThan(RandomGenerator.RANDOM_NUMBER_RANGE);
    }
}
