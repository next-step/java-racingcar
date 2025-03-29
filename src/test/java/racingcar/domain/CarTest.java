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
        Assertions.assertThatThrownBy(() -> new Car("car", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("random 값이 4 이상이면 전진한다.")
    void moveIfUpperMovableValue() {
        Car car = new Car("car");
        MoveStrategy moveStrategy = new MoveStrategy(() -> 4);

        car.move(moveStrategy);
        assertThat(car).isEqualTo(new Car("car", 1));
    }

    @Test
    @DisplayName("random 값이 4 미만이면 정지한다.")
    void stopIfLowerMovableValue() {
        Car car = new Car("car");
        MoveStrategy moveStrategy = new MoveStrategy(() -> 3);

        car.move(moveStrategy);
        assertThat(car).isEqualTo(new Car("car", 0));
    }

    @Test
    @DisplayName("자동차의 위치가 더 앞선 자동차를 반환한다.")
    void findCarAheadOf() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 0);

        assertThat(car1.findCarAhead(car2)).isEqualTo(car1);
        assertThat(car2.findCarAhead(car1)).isEqualTo(car1);
    }

    @Test
    @DisplayName("자동차가 같은 위치에 있으면 true를 반환한다.")
    void isSamePositionTrue() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 1);

        assertThat(car1.isSamePositionWith(car2)).isTrue();
    }

    @Test
    @DisplayName("자동차가 다른 위치에 있으면 false를 반환한다.")
    void isSamePositionFalse() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);

        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }
}