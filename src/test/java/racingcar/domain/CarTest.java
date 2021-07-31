package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new RacingMoveStrategy();
    }

    @Test
    @DisplayName("자동차 4이상일 경우만 전진 테스트")
    void carMoveTrueTest() {

        // given
        Car car = new Car(moveStrategy, "volvo", 0);

        // when
        car.move(3);
        car.move(4);
        car.move(5);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름 저장 테스트")
    void carNameCheckTest() {
        Car car = new Car(moveStrategy, "benz");

        String carName = car.getName();

        assertThat(carName).isEqualTo("benz");
    }
}