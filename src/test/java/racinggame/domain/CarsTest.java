package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void moveCarsTest() {
        Car car1 = new Car("자동차1", 0, () -> true);
        Car car2 = new Car("자동차2", 0, () -> true);
        List<Car> carList = Arrays.asList(car1, car2);
        Cars cars = new Cars(carList);

        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }

    @Test
    void winnerTest() {
        Car car1 = new Car("자동차1", 0, () -> true);
        Car car2 = new Car("자동차2", 0, () -> false);
        List<Car> carList = Arrays.asList(car1, car2);
        Cars cars = new Cars(carList);

        cars.moveCars();
        assertThat(cars.getWinners().getCars().get(0).getCarName().toString()).isEqualTo("자동차1");
    }
}
