package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void racing() {
        // given
        RacingCar racingCar = new RacingCar(3);
        List<Car> cars = racingCar.getCars();

        // when
        racingCar.racing();

        // then
        assertThat(cars.get(0).getStatus()).isLessThanOrEqualTo(1);
    }

}