package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("거리")
class DistanceTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Distance.from(Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("반드시 0 이상")
    void instance_negative_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Distance.from(-1));
    }
}
