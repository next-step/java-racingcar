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
}