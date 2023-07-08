package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.random.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차를 한꺼번에 이동시킨다.")
    void moveAllCars() {
        final Cars cars = new Cars(List.of("a", "b", "c"));
        final RandomGenerator mockRandomGenerator = new RandomGenerator() {
            @Override
            public int extractRandomSingleDigit() {
                return 4;
            }
        };

        cars.move(mockRandomGenerator);

        assertThat(cars.format(car -> "name : " + car.getName() + ", position : " + car.getPosition()))
                .containsExactly("name : a, position : 1", "name : b, position : 1", "name : c, position : 1");
    }
}