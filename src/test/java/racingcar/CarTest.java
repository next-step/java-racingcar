package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;

class CarTest {
    @Test
    @DisplayName("전진 조건을 만족하면 자동차는 전진한다.")
    void carShouldMoveWhenConditionIsMet() {
        Car car = new Car();
        MoveStrategy movableStrategy = () -> true;

        car.move(movableStrategy);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건을 만족하지 않으면 자동차는 멈춘다.")
    void carShouldNotMoveWhenConditionIsNotMet() {
        Car car = new Car();
        MoveStrategy immovableStrategy = () -> false;

        car.move(immovableStrategy);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
