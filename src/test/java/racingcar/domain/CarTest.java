package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 4이상일 경우만 전진 테스트")
    void carMoveTrueTest() {

        // given
        Car car = new Car("volvo", 0);
        MoveStrategy moveStrategy = new RacingMoveStrategy();

        // when
        car.move(moveStrategy);
        car.move(moveStrategy);
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름 저장 테스트")
    void carNameCheckTest() {
        Car car = new Car("benz");

        String carName = car.getName();

        assertThat(carName).isEqualTo("benz");
    }
}