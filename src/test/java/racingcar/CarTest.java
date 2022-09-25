package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    public static final int TRY_COUNT = 5;

    @Test
    @DisplayName("자동차가 주어진 수 만큼 움직이거나 멈춘다.")
    void tryMove() {
        Car car = new Car();

        car.tryMove(TRY_COUNT);

        assertThat(car.getTotalTryCount()).isEqualTo(TRY_COUNT);
    }
}