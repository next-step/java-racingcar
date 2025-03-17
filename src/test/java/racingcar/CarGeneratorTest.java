package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarGeneratorTest {
    private Integer carCount = 3;

    @Test
    @DisplayName("주어진 수 만큼 자동차가 생성되어야 한다.")
    void generateCars() {
        List<Car> cars = new CarGenerator().generateCar(carCount);
        Assertions.assertThat(cars.size()).isEqualTo(carCount);
    }
}