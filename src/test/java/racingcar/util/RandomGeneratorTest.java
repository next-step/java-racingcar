package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.RandomGenerator.randomNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("randomNumber 메소드는 파라미터로 넘겨진 수 미만의 값만 반환 한다.")
    void randomNumber_withBound() {
        assertThat(randomNumber(10)).isLessThan(10);
    }
}