package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void racing() {
        // given
        RacingCar racingCar = new RacingCar(new String[]{"a", "b", "c"});
        List<Car> cars = racingCar.getCars();

        // when
        racingCar.racing();

        // then
        for (Car car : cars) {
            assertThat(car.getStatus()).isLessThanOrEqualTo(1);
        }
    }

}