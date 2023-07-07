package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarStatus;
import racingcar.domain.Cars;

import java.util.List;

class CarsTest {
    @Test
    void carsTest_maxPosition() {
        Cars cars = new Cars(
                new Car("pobi", 2),
                new Car ("honux", 1)
        );

        Assertions.assertThat(cars.maxPosition()).isEqualTo(2);
    }

    @Test
    void carsTest_mapToStatus() {
        Cars cars = new Cars(
                new Car("pobi", 3),
                new Car ("honux", 4)
        );

        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .map(CarStatus::getName)
        ).contains("pobi", "honux");
        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .mapToInt(CarStatus::getPosition)
        ).contains(3, 4);
    }

    @Test
    void carsTest_moveAll() {
        Cars cars = new Cars(
                new Car("pobi", 2, new MockRandom(4)),
                new Car ("honux", 1, new MockRandom(4))
        );
        cars.moveAll();

        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .mapToInt(CarStatus::getPosition)
        ).containsExactly(3, 2);
    }

    @Test
    void carsTest_findWinnerNames() {
        Cars cars = new Cars(
                new Car("pobi", 3),
                new Car ("honux", 2),
                new Car("gugu", 4),
                new Car("sola", 4)
        );

        Assertions.assertThat(cars.findWinnerNames()).containsExactly(new CarName("gugu"), new CarName("sola"));
    }
}
