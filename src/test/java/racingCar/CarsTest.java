package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    void generateCars() {
        String[] names = {"yeo", "jin", "yu"};
        Cars cars = Cars.generateCars(Arrays.asList(names));
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차를 입력받지 않을 경우 exception")
    void negativeCars() {
        String[] names = {};
        assertThatThrownBy(() -> Cars.generateCars(Arrays.asList(names))).isInstanceOf(RuntimeException.class);
    }
}
