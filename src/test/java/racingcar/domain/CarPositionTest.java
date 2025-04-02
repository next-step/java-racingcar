package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarPositionTest {

    @Test
    @DisplayName("자동차 위치가 음수이면, 예외가 발생한다.")
    void constructWithNegativePosition() {
        assertThatThrownBy(() -> new Car("car", -1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 전진한다.")
    void move() {
        assertThat(new CarPosition(0).move()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치를 반환한다.")
    void getValue() {
        assertThat(new CarPosition(1).getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 위치가 더 앞선 자동차를 반환한다.")
    void findCarAheadOf() {
        assertThat(new CarPosition(1).isAheadOf(new CarPosition(0))).isTrue();
        assertThat(new CarPosition(0).isAheadOf(new CarPosition(1))).isFalse();
    }

    @Test
    @DisplayName("자동차가 같은 위치에 있으면 true를 반환한다.")
    void isSame() {
        assertThat(new CarPosition(1).equals(new CarPosition(1))).isTrue();
        assertThat(new CarPosition(1).equals(new CarPosition(2))).isFalse();
    }

}