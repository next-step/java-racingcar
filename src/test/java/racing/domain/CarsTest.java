package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void moveCarsTest() {
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        List<Car> carList = Arrays.asList(car1, car2);
        Cars cars = new Cars(carList);

        cars.moveCars(() -> false);
        for (Car car : cars.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(new Position(0));
        }

        cars.moveCars(() -> true);
        for (Car car : cars.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @Test
    void findWinnersTest() {
        Car car1 = new Car("자동차1", 3);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차2", 2);
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners()).containsExactly(car1, car2);
        assertThat(cars.findWinners()).doesNotContain(car3);
    }

    @Test
    void findWinnersNameTest() {
        Car car1 = new Car("자동차1", 3);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차2", 2);
        List<Car> carList = Arrays.asList(car1, car2, car3);
        List<Car> carList2 = Arrays.asList(car1, car3);
        Cars cars = new Cars(carList);
        Cars cars2 = new Cars(carList2);

        assertThat(cars.findWinnersName()).isEqualTo("자동차1,자동차2");
        assertThat(cars2.findWinnersName()).isEqualTo("자동차1");
    }
}