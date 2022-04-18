package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("거리")
class DistanceTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Distance.from(0));
        assertThatNoException().isThrownBy(() -> Distance.from(Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("반드시 0 이상")
    void instance_negative_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Distance.from(-1));
    }

    @Test
    @DisplayName("더하기")
    void add() {
        //given, when
        Distance distance = Distance.ONE.add(Distance.ONE);
        //then
        assertThat(distance).isEqualTo(Distance.from(2));
    }

    @Test
    @DisplayName("1의 거리보다 더 큰지 비교")
    void greaterThan() {
        assertThat(Distance.ONE.greaterThan(Distance.ZERO)).isTrue();
        assertThat(Distance.ONE.greaterThan(Distance.ONE)).isFalse();
    }
}
