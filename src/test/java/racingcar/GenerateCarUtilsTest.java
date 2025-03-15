package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateCarUtilsTest {

    @Test
    @DisplayName("자동차 개수만큼 자동차가 생성되어야 한다.")
    void generateCars() {
        int carCount = 5;
        List<Car> cars = GenerateCarUtils.generateCars(carCount);
        Assertions.assertThat(cars.size()).isEqualTo(carCount);
    }
}
