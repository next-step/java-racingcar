package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.Fixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 클래스 테스트")
class CarTest {

    @DisplayName("자동차는 MoveStrategy 를 가지고 초기화 한다.")
    @Test
    void initWithMoveStrategy() {
        assertThat(Car.from(Fixture.alwaysMoveStrategy())).isNotNull();
    }

    @DisplayName("자동차는 MoveStrategy 없이 초기화 할 수 없다.")
    @Test
    void initWithOutMoveStrategy() {
        assertThatThrownBy(() -> Car.from(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("MoveStrategy 가 true 일 경우 자동차는 +1 만큼 이동한다.")
    @Test
    void carMoveWhenMoveStrategyReturnTrue() {
        Car car = Car.from(Fixture.alwaysMoveStrategy());

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move();

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @DisplayName("MoveStrategy 가 false 일 경우 움직이지 않는다.")
    @Test
    void carDoesNotMoveWhenMoveStrategyReturnFalse() {
        Car car = Car.from(Fixture.neverMoveStrategy());

        assertThat(car.currentPosition()).isEqualTo(0);

        car.move();

        assertThat(car.currentPosition()).isEqualTo(0);
    }
}
