package car.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.random.RandomGenerator;

class CarsTest {

    @Test
    @DisplayName("자동차를 한꺼번에 이동시킨다.")
    void moveAllCars() {
        Cars cars = new Cars("a,b,c");
        RandomGenerator mockRandomGenerator = new RandomGenerator() {
            @Override
            public int extractRandomSingleDigit() {
                return 4;
            }
        };

        cars.move(mockRandomGenerator);

        for (Car car : cars.getList()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}