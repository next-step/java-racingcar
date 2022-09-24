package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void racing() {
        // given
        RacingCar racingCar = new RacingCar(3);
        List<Car> cars = racingCar.getCars();

        // when
        racingCar.racing();

        // then
//        Assertions.assertThat(cars.get(0).getStatus()).isEqualTo();
    }

    @Test
    void tryMove() {
        // given
        RacingCar racingCar = new RacingCar(3);
        Car car = racingCar.getCars().get(0);

        // when
        racingCar.tryMove(car, 5);

        // then
        assertThat(car.getStatus()).isEqualTo(1);
    }

}