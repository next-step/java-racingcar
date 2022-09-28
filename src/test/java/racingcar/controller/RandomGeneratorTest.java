package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @DisplayName("0이상 10미만의 임의 숫자를 생성한다.")
    @Test
    void randomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();
        assertThat(randomGenerator.randomNumber()).isGreaterThanOrEqualTo(0);
        assertThat(randomGenerator.randomNumber()).isLessThan(10);
    }
}