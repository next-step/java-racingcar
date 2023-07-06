package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CarsTest {
    @Test
    void carsTest_maxPosition() {
        Car car1 = new Car(new CarName("pobi"), new MockRandom(4));
        Car car2 = new Car(new CarName("honux"), new MockRandom(3));
        car1.move();

        List<Car> carList = List.of(car1, car2);
        Cars cars = new Cars(carList);

        Assertions.assertThat(cars.maxPosition()).isEqualTo(2);
    }

    @Test
    void carsTest_mapToStatus() {
        Car car1 = new Car(new CarName("pobi"), new MockRandom(4));
        Car car2 = new Car(new CarName("honux"), new MockRandom(4));

        List<Car> carList = List.of(car1, car2);
        Cars cars = new Cars(carList);

        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .map(CarStatus::getName)
        ).contains("pobi", "honux");
        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .mapToInt(CarStatus::getPosition)
        ).contains(1, 1);
    }

    @Test
    void carsTest_moveAll() {
        Car car1 = new Car(new CarName("pobi"), new MockRandom(4));
        Car car2 = new Car(new CarName("honux"), new MockRandom(4));

        List<Car> carList = List.of(car1, car2);
        Cars cars = new Cars(carList);
        cars.moveAll();

        Assertions.assertThat(cars.mapToStatus()
                .stream()
                .mapToInt(CarStatus::getPosition)
        ).contains(2, 2);
    }

    @Test
    void carsTest_findWinnerNames() {
        Car car1 = new Car(new CarName("pobi"), new MockRandom(4));
        Car car2 = new Car(new CarName("honux"), new MockRandom(3));
        Car car3 = new Car(new CarName("gugu"), new MockRandom(4));

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        cars.moveAll();

        Assertions.assertThat(cars.findWinnerNames()
                .stream()
                .map(CarName::getName)
        ).contains("pobi", "gugu");
    }
}
