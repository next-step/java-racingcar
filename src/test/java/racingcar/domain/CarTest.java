package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static final Car MOVING_CAR = new Car(1);

    @Test
    @DisplayName("자동차가 움직이는 기능 구현 자동차의 위치가 1 증가한다.")
    void movingCarTest_positionOneIncrease() {
        Car car = new Car();
        car.moves(() -> true);

        assertThat(car).isEqualTo(MOVING_CAR);
    }
}
