package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private String[] names;
    private Cars cars;

    @BeforeEach
    void beforeEach() {
        names = new String[]{"자동차1", "자동차2", "자동차3"};
        cars = new Cars(names);
    }

    @Nested
    class NamesTest {
        @Test
        void cars_수() {
            assertThat(cars.getCarList().size()).isEqualTo(3);
        }

        @Test
        void carNames() {
            List<Car> carList = cars.getCarList();
            for (int i = 0; i < carList.size(); i++) {
                assertThat(carList.get(i).getName()).isEqualTo(names[i]);
            }
        }
    }

    @Test
    void moveCarsTest() {
        cars.moveCar(new Moving());
        for (Car car : cars.getCarList()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(1);
        }
    }
}