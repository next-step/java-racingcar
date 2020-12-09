package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("자동차 생성 횟수 확인")
    void createCars() {
        Cars cars = new Cars(3);
        List<Car> createCars = cars.cars();
        assertThat(createCars.size()).isEqualTo(3);
    }
}
