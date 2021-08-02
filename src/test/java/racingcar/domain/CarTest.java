package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void carMoveTest() {
        // given
        Car car = new Car("volvo", 0);
        MoveStrategy moveStrategy = () -> true;

        // when
        car.move(moveStrategy);
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 전진 실패 테스트")
    void carMoveFailTest() {
        // given
        Car car = new Car("volvo", 0);
        MoveStrategy moveStrategy = () -> false;

        // when
        car.move(moveStrategy);
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름 저장 테스트")
    void carNameCheckTest() {
        Car car = new Car("benz");

        String carName = car.getName();

        assertThat(carName).isEqualTo("benz");
    }
}