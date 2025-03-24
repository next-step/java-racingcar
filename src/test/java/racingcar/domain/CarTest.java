package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 위치가 음수이면, 예외가 발생한다.")
    void constructWithNegativePosition() {
        Assertions.assertThatThrownBy(() -> new Car(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("random 값이 4 이상이면 전진한다.")
    void moveIfUpperMovableValue() {
        Car car = new Car();
        NumberGenerator numberGenerator = () -> 4;
        assertThat(car.move(numberGenerator)).isEqualTo(1);
    }

    @Test
    @DisplayName("random 값이 4 미만이면 정지한다.")
    void stopIfLowerMovableValue() {
        Car car = new Car();
        NumberGenerator numberGenerator = () -> 3;
        assertThat(car.move(numberGenerator)).isZero();
    }

}