package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.fixture.CarConstantsFixture.CAR_NAME;

class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void car_move_test() {
        Car car = new Car(CAR_NAME);
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void car_stop_test() {
        Car car = new Car(CAR_NAME);
        car.move(() -> false);

        assertThat(car.getPosition()).isZero();
    }
}