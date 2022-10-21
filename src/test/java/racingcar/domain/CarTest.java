package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final NumberStrategy overThresholdNumberStrategy = new OverThresholdNumberStrategy();
    private final NumberStrategy underThresholdNumberStrategy = new UnderThresholdNumberStrategy();

    @Test
    @DisplayName("임계치를 넘는 경우 position 값을 1 증가시킨다.")
    void moveForward_ShouldPlus1PositionValue() {
        Car car = Car.nameOf("Test");

        car.moveForward(overThresholdNumberStrategy);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("임계치를 넘지 않는 경우 position 값을 증가시키지 않는다.")
    void moveForward_ShouldNotPlusPositionValue() {
        Car car = Car.nameOf("Test");

        car.moveForward(underThresholdNumberStrategy);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 이동한 경우 position 값은 1과 같기 때문에 true 값을 반환한다.")
    void isSamePosition_ShouldReturn1WhenCarMoved() {
        Car car = Car.nameOf("Test");
        car.moveForward(overThresholdNumberStrategy);

        boolean actual = car.isSamePosition(1);

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차가 이동하지 않은 경우 position 값은 0과 같기 때문에 false 값을 반환한다.")
    void isSamePosition_ShouldReturn0WhenCarDidnMoved() {
        Car car = Car.nameOf("Test");

        boolean actual = car.isSamePosition(0);

        assertThat(actual).isEqualTo(true);
    }
}
