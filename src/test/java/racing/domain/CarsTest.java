package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void cars_수() {
        Cars cars = new Cars(2);
        assertThat(cars.getCarList().size()).isEqualTo(2);
    }

    @Test
    void moveCarsTest() {
        Cars cars = new Cars(3);
        cars.moveCar(new Moving());
        for (Car car : cars.getCarList()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(1);
        }
    }
}