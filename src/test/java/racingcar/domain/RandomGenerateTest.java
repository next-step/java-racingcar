package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGenerateTest {

    @Test
    @DisplayName("랜덤한 수의 범위는 0 ~ 9까지이다.")
    void randomValue() {
        assertThat(RandomGenerate.makeRandom()).isBetween(0, 9);
    }

}