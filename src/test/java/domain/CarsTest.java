package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @DisplayName("입력받은 숫자만큼 자동차를 생성한다.")
    @Test
    void generateCarsTest() {
        int numberOfCars = 3;

        Cars cars = new Cars(numberOfCars);

        assertThat(cars.getCars()).asInstanceOf(list(Car.class)).hasSize(numberOfCars);
    }
}