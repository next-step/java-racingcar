package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.generator.MovableNumberGenerator;
import racingcar.generator.NonMovableNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {
    @Test
    void racingTest_by_movableNumberGenerator() {
        Racing racing  = new Racing("aCar,bCar");
        List<Car> cars = racing.race(new MovableNumberGenerator());
        assertThat(cars.get(0).getMovementCount()).isEqualTo(1);
    }

    @Test
    void racingTest_by_nonMovableNumberGenerator() {
        Racing racing  = new Racing("aCar,bCar");
        List<Car> cars = racing.race(new NonMovableNumberGenerator());
        assertThat(cars.get(0).getMovementCount()).isEqualTo(0);
    }

    @Test
    void racingTest_CarName_validation_5자초과() {
        assertThatThrownBy(() -> new Car( "abcdef"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void racingTest_carNames_split_and_getCars() {
       Racing racing  = new Racing("aCar,bCar");
       Car car = new Car("aCar");

       assertThat(racing.getCars()).contains(car);
    }

    @Test
    void racingTest_우승자구하기() {
        Racing racing  = new Racing(Arrays.asList(
                new Car("aCar", 3),
                new Car("bCar", 1),
                new Car("cCar", 3)));

        List<Car> winnerCars = Arrays.asList(
                new Car("aCar",3),
                new Car("cCar",3));

        assertThat(racing.getWinnerCars()).isEqualTo(winnerCars);
    }
}