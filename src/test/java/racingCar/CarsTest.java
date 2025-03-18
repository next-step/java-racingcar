package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    void generateCars() {
        Cars cars = Cars.generateCars(3);
        assertThat(cars.getCars()).hasSize(3);
    }
    @Test
    @DisplayName("음수를 입력받을 경우 exception")
    void negative() {
        assertThatThrownBy(() -> Cars.generateCars(-1)).isInstanceOf(RuntimeException.class);
    }
}
