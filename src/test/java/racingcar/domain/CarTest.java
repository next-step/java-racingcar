package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하면, 에러가 발생한다.")
    void carNameShouldNotExceed5() {
        String longName = "flower";
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

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
        MoveStrategy moveStrategy = new MoveStrategy(() -> 4);

        car.move(moveStrategy);
        assertThat(car).isEqualTo(new Car(1));
    }

    @Test
    @DisplayName("random 값이 4 미만이면 정지한다.")
    void stopIfLowerMovableValue() {
        Car car = new Car();
        MoveStrategy moveStrategy = new MoveStrategy(() -> 3);

        car.move(moveStrategy);
        assertThat(car).isEqualTo(new Car(0));
    }

}